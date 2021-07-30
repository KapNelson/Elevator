package com.sytoss.edu2021.strategy;

import lombok.Builder;
import org.quartz.JobDataMap;

public interface WaitingStrategy {
    void startJob(JobDataMap data);
}
