package com.sytoss.edu2021.services;

import com.sytoss.edu2021.bom.EngineBOM;
import com.sytoss.edu2021.common.Direction;
import com.sytoss.edu2021.common.RouteBOM;
import com.sytoss.edu2021.repo.EngineRepository;
import com.sytoss.edu2021.repo.RouteRepository;
import com.sytoss.edu2021.repo.dto.EngineDTO;
import com.sytoss.edu2021.repo.dto.RouteDTO;
import com.sytoss.edu2021.repo.dto.RouteDTOId;
import com.sytoss.edu2021.services.convertor.EngineConvertor;
import com.sytoss.edu2021.services.convertor.RouteConvertor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;



public class EngineRunnable implements Runnable{

//    @Autowired
//    RouteRepository routeRepository;
//    @Autowired
//    EngineRepository engineRepository;
    private static RouteRepository routeRepository;

    private static EngineRepository engineRepository;
    private long waitTime;
    private EngineBOM engine;
    public EngineRunnable(EngineBOM engineBOM)
    {
        waitTime = 5000;
        engine = engineBOM;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(waitTime);
            System.out.println("Прошло 5 секунд текущий этаж:" + engine.getCurrentFloor() + " Состояние " + engine.getStatus());

            RouteDTO routeDTOs[] = routeRepository.findAllByRouteDTOId_IdEngine(engine.getId());

            RouteBOM route = new RouteBOM();
            new RouteConvertor().fromDTO(routeDTOs,route);
            engine.setRoute(route);
            engine.getRoute().setDirection(Direction.UP);
            switch (engine.getStatus())
            {
                case RUNNING_DOWN:
                case RUNNING_UP:
                    engine.move();
                    break;
                case STOP:
                    if(engine.getCurrentFloor() < Collections.max(engine.getRoute().getQueueOfFloors()))
                    {
                        engine.start();
                    }

                    break;

                case BROKEN:
                    break;
            }
            EngineDTO engineDTO = new EngineDTO();
            new EngineConvertor().toDTO(engine, engineDTO);
            engineRepository.save(engineDTO);
            System.out.println(Collections.max(engine.getRoute().getQueueOfFloors()));
            if(engine.getCurrentFloor() < Collections.max(engine.getRoute().getQueueOfFloors()))
            {
                EngineRunnable runnable = new EngineRunnable(engine);
                runnable.setEngineRepository(engineRepository);
                runnable.setRouteRepository(routeRepository);
                FutureTask<String>
                        futureTask = new FutureTask<String>(runnable,"FutureTask is complete");

                //ExecutorService executor = Executors.newFixedThreadPool(10);
                ExecutorService executor = Executors.newCachedThreadPool();


                executor.submit(futureTask);
                while(!futureTask.isDone())
                {
                    Thread.sleep(100);
                }


                executor.shutdown();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setRouteRepository(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public void setEngineRepository(EngineRepository engineRepository) {
        this.engineRepository = engineRepository;
    }
}
