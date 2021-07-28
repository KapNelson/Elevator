package com.sytoss.edu2021;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiEngineApplication {
    public static Scheduler scheduler = null;

    public static void main(String[] args) {
        startScheduler();
        SpringApplication.run(ApiEngineApplication.class, args);
    }

    private static void startScheduler() {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        try {
            scheduler = schedulerFactory.getScheduler();
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}
