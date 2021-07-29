package com.sytoss.edu2021;


import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class ApiEngineApplication {

    public static final Scheduler scheduler = createScheduler();


    public static void main(String[] args) {
        SpringApplication.run(ApiEngineApplication.class, args);

    }

    private static Scheduler createScheduler()  {
        try {
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.start();
            return scheduler;
        }catch(SchedulerException e){
            throw new RuntimeException(e);
        }
    }
}
