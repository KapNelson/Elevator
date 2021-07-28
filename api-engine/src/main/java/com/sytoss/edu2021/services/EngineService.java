package com.sytoss.edu2021.services;

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

import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

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
        EngineRunnable runnable = new EngineRunnable(engineBOM);
        runnable.setEngineRepository(engineRepository);
        runnable.setRouteRepository(routeRepository);
        FutureTask<String>
                futureTask = new FutureTask<>(runnable,
                "FutureTask is complete");

        ExecutorService executor = Executors.newCachedThreadPool();

        executor.submit(futureTask);



        while(!futureTask.isDone())
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            if(!engineBOM.getRoute().getQueueOfFloors().isEmpty())
//            {
//                executor.shutdown();
//                runnable = new EngineRunnable(engineBOM);
//                futureTask = new FutureTask<>(runnable,"FutureTask is complete");
//
//                executor = Executors.newCachedThreadPool();
//
//                executor.submit(futureTask);
//
//            }

        }

        executor.shutdown();

    }

    public EngineBOM getEngine(Integer engineId) {
        EngineDTO engineDTO = engineRepository.findEngineDTOById(engineId);
        EngineBOM engineBOM = new EngineBOM();
        new EngineConvertor().fromDTO(engineDTO,engineBOM);
        return engineBOM;
    }



}
