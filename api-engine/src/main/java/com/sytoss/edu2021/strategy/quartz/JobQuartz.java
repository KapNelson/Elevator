package com.sytoss.edu2021.strategy.quartz;

import com.sytoss.edu2021.strategy.WaitingStrategy;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class JobQuartz implements WaitingStrategy {
    public Scheduler scheduler;
    private long waitTime;

    public JobQuartz(long waitTime) {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        this.waitTime = waitTime;
        try {
            scheduler = schedulerFactory.getScheduler();
            scheduler.start();
        } catch (SchedulerException e) {
            throw new RuntimeException("Error while creating JobQuartz.class");
        }
    }

    @Override
    public void startJob(JobDataMap data) {
        try {
            if (!scheduler.checkExists(new JobKey("myJob", "group1"))) {
                JobDetail job = JobBuilder.newJob(ElevatorJob.class)
                        .withIdentity("myJob", "group1")
                        .usingJobData(data)
                        .build();

                Trigger trigger = TriggerBuilder.newTrigger()
                        .withIdentity("myTrigger", "group1")
                        .startNow()
                        .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInMilliseconds(waitTime)
                                .repeatForever())
                        .build();

                scheduler.scheduleJob(job, trigger);
            }
        } catch (SchedulerException e) {
            throw new RuntimeException("Error while starting JobQuartz.startJob");
        }
    }
}