package com.sytoss.edu2021.strategy.future;

import com.sytoss.edu2021.bom.EngineBOM;
import com.sytoss.edu2021.repo.EngineRepository;
import com.sytoss.edu2021.repo.RouteRepository;
import com.sytoss.edu2021.strategy.WaitingStrategy;
import org.quartz.JobDataMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import java.util.concurrent.FutureTask;

public class EngineFutureTask implements WaitingStrategy {

    private List<EngineBOM> engineBOMs;
    private RouteRepository routeRepository;
    private EngineRepository engineRepository;
    private long waitTime;

    public EngineFutureTask(long waitTime) {
        this.waitTime = waitTime;
    }


    @Override
    public void startJob(JobDataMap data) {


        engineBOMs = (List<EngineBOM>) data.get("engine");

        routeRepository = (RouteRepository) data.get("routeRepository");
        engineRepository = (EngineRepository) data.get("engineRepository");

        EngineRunnable runnable = new EngineRunnable(engineBOMs, waitTime);
        runnable.setEngineRepository(engineRepository);
        runnable.setRouteRepository(routeRepository);

        FutureTask<String> futureTask = new FutureTask<>(runnable, "FutureTask is complete");
        CompletableFuture<String> future = new CompletableFuture();
        future.runAsync(runnable);
    }
}
