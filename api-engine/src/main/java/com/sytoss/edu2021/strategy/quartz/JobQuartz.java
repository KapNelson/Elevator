package com.sytoss.edu2021.strategy.quartz;

import com.sytoss.edu2021.strategy.WaitingStrategy;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class JobQuartz implements WaitingStrategy {
    public Scheduler scheduler = null;

    public JobQuartz() {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        try {
            scheduler = schedulerFactory.getScheduler();
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
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
                                .withIntervalInSeconds(5)
                                .repeatForever())
                        .build();

                scheduler.scheduleJob(job, trigger);
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}