package com.abosen.demo.spring.quartz.basic;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author qiubaisen
 * @date 2018/11/6
 */
public class SimpleTriggerRunner {
    public static void main(String[] args) throws Exception {
        JobDetail jobDetail = JobBuilder.newJob(SimpleJob.class).withIdentity("job1_1", "jGroup1").build();

        SimpleTrigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("trigger1_1", "tGroup1")
                .startNow()
                .withSchedule(
                        SimpleScheduleBuilder
                                .repeatSecondlyForever(2)
                                .withRepeatCount(5)
                )
                .build();

        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();

        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }
}
