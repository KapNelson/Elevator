package com.sytoss.edu2021.strategy.future;

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
import org.springframework.beans.factory.annotation.Value;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;



public class EngineRunnable implements Runnable{

    private RouteRepository routeRepository;

    private EngineRepository engineRepository;
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

            RouteDTO routeDTOs[] = routeRepository.findAllByRouteDTOId_IdEngine(engine.getId());
            RouteBOM route = new RouteBOM();
            new RouteConvertor().fromDTO(routeDTOs,route);
            engine.setRoute(route);
            engine.getRoute().setDirection(engine.getCurrentFloor(), engine.getRoute().getMinValue());
            CompletableFuture<String> future = new CompletableFuture();
            switch (engine.getStatus())
            {
                case RUNNING_DOWN:
                case RUNNING_UP:
                    engine.move();
                    break;
                case STOP:
                    RouteDTOId removeRoute = new RouteDTOId();
                    removeRoute.setFloorNumber(engine.getCurrentFloor());
                    removeRoute.setIdEngine(engine.getId());

                    RouteDTO remove = new RouteDTO();
                    remove.setRouteDTOId(removeRoute);
                    routeRepository.delete(remove);
                    if(!engine.getRoute().getQueueOfFloors().isEmpty())
                    {
                        engine.start();
                    }
                    else
                    {
                        future.complete("");
                    }

                    break;

                case BROKEN:
                    break;
            }
            EngineDTO engineDTO = new EngineDTO();
            new EngineConvertor().toDTO(engine, engineDTO);
            engineRepository.save(engineDTO);

            EngineRunnable runnable = new EngineRunnable(engine);
            runnable.setEngineRepository(engineRepository);
            runnable.setRouteRepository(routeRepository);
            FutureTask<String>
                    futureTask = new FutureTask<String>(runnable,"FutureTask is complete");


            future.runAsync(runnable);


            //executor.shutdown();

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