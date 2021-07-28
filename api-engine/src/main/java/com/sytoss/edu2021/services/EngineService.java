package com.sytoss.edu2021.services;

import com.sytoss.edu2021.ElevatorJob;
import com.sytoss.edu2021.bom.EngineBOM;
import com.sytoss.edu2021.common.EngineStatus;
import com.sytoss.edu2021.repo.EngineRepository;
import com.sytoss.edu2021.repo.RouteRepository;
import com.sytoss.edu2021.repo.dto.EngineDTO;
import com.sytoss.edu2021.services.convertor.EngineConvertor;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class EngineService {

    @Autowired
    EngineRepository engineRepository;
    @Autowired
    RouteRepository routeRepository;

    public EngineBOM addEngine(Integer buildingId, Integer cabinId) {
            EngineDTO engineDTO = new EngineDTO();
            engineDTO.setId(cabinId);
            engineDTO.setBuildingId(buildingId);
            engineDTO.setCabinId(cabinId);
            engineDTO.setCurrentFloor(1);
            engineDTO.setEngineStatus(EngineStatus.STOP);
            engineDTO = engineRepository.save(engineDTO);
            EngineBOM engineBOM = new EngineBOM();
            new EngineConvertor().fromDTO(engineDTO,engineBOM);
            return engineBOM;
        }

    public void startMovement(Integer buildingId, Integer cabinNumber) {
        EngineDTO engineDTO = engineRepository.findEngineDTOByBuildingIdAndCabinId(buildingId,cabinNumber);
        EngineBOM engineBOM = new EngineBOM();
        new EngineConvertor().fromDTO(engineDTO,engineBOM);

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.start();


            ElevatorJob.setRouteRepository(routeRepository);
            ElevatorJob.setEngineRepository(engineRepository);
            ElevatorJob.addEngine(engineBOM);

            JobDetail job = JobBuilder.newJob(ElevatorJob.class)
                    .withIdentity("myJob", "group1")
                    .build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("myTrigger", "group1")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(5)
                            .repeatForever())
                    .build();

            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public EngineBOM getEngine(Integer engineId) {
        EngineDTO engineDTO = engineRepository.findEngineDTOById(engineId);
        EngineBOM engineBOM = new EngineBOM();
        new EngineConvertor().fromDTO(engineDTO,engineBOM);
        return engineBOM;
    }



}
