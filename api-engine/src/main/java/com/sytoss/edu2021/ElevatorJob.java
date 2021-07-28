package com.sytoss.edu2021;

import com.sytoss.edu2021.bom.EngineBOM;
import com.sytoss.edu2021.common.Direction;
import com.sytoss.edu2021.repo.EngineRepository;
import com.sytoss.edu2021.repo.RouteRepository;
import com.sytoss.edu2021.repo.dto.EngineDTO;
import com.sytoss.edu2021.repo.dto.RouteDTO;
import com.sytoss.edu2021.services.convertor.EngineConvertor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EnableScheduling
public class ElevatorJob implements Job{

    private static List<EngineBOM> engineBOMS = new ArrayList<>();
    private static RouteRepository routeRepository;
    private static EngineRepository engineRepository;


    public ElevatorJob(List<EngineBOM> engineBOM) {
        this.engineBOMS = engineBOM;
    }

    public ElevatorJob() {
    }

    public static void addEngine(EngineBOM engineBOM) {
        engineBOMS.add(engineBOM);
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Прошло 5 секунд!");
        for (EngineBOM engine : engineBOMS) {
            RouteDTO[] routeDTOS = routeRepository.findAllByRouteDTOId_IdEngine(engine.getId());

            Set<Integer> set = new HashSet<>();
            for (RouteDTO route : routeDTOS) {
                set.add(route.getRouteDTOId().getFloorNumber());
            }
            engine.getRoute().setQueueOfFloors(set);
            engine.getRoute().setDirection(Direction.UP);
            switch (engine.getStatus()) {
                case RUNNING_DOWN:
                case RUNNING_UP:
                    engine.move();
                    break;
                case STOP:
                    if (!engine.getRoute().getQueueOfFloors().isEmpty()) {
                        engine.start();
                    }
                    break;
                case BROKEN:
                    break;
            }

            EngineDTO engineDTO = new EngineDTO();
            new EngineConvertor().toDTO(engine, engineDTO);
            engineRepository.save(engineDTO);
        }
    }

    public static void setRouteRepository(RouteRepository routeRepository) {
        ElevatorJob.routeRepository = routeRepository;
    }

    public static void setEngineRepository(EngineRepository engineRepository) {
        ElevatorJob.engineRepository = engineRepository;
    }
}
