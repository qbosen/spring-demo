package com.abosen.demo.spring.quartz.basic;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @author qiubaisen
 * @date 2018/11/8
 */
public class CronTriggerRunner {
    public static void main(String[] args) throws Exception {
        JobDetail jobDetail = JobBuilder.newJob()
                .withIdentity("job1_2", "jGroup1")
                .ofType(SimpleJob.class)
                .build();
        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1_2", "tGroup1")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("0/2 * * * * ?")
                )
                .build();

        StdSchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail, trigger);

        scheduler.start();

        Thread.sleep(30L * 1000L);
        System.out.println("Shut down " + scheduler.getSchedulerName() + " at " + new Date());
        scheduler.shutdown(true);
    }
}
