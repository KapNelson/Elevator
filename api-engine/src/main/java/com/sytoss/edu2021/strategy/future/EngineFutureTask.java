package com.sytoss.edu2021.strategy.future;

import com.sytoss.edu2021.bom.EngineBOM;
import com.sytoss.edu2021.repo.EngineRepository;
import com.sytoss.edu2021.repo.RouteRepository;
import com.sytoss.edu2021.repo.dto.EngineDTO;
import com.sytoss.edu2021.services.convertor.EngineConvertor;
import com.sytoss.edu2021.strategy.WaitingStrategy;
import org.apache.catalina.Engine;
import org.quartz.JobDataMap;
import org.springframework.util.RouteMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class EngineFutureTask implements WaitingStrategy {

    private EngineBOM engineBOM;
    private RouteRepository routeRepository;
    private EngineRepository engineRepository;



    @Override
    public void startJob(JobDataMap data) {

        engineBOM = (EngineBOM)data.get("engine");
        routeRepository = (RouteRepository) data.get("routeRepository");
        engineRepository = (EngineRepository) data.get("engineRepository");

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

        }

        executor.shutdown();


    }
}
