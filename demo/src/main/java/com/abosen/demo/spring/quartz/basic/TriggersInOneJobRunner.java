package com.abosen.demo.spring.quartz.basic;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @author qiubaisen
 * @date 2018/11/7
 */
public class TriggersInOneJobRunner {
    /**
     * 1. job 需要 storeDurably()
     * 2. trigger 需要 forJob(job)
     * 3. scheduler 添加 job 和 triggers
     */
    public static void main(String[] args) throws Exception {
        JobDetail jobDetail = JobBuilder
                .newJob(SimpleJob.class)
                .withIdentity("job1_1", "jGroup1")
                .storeDurably()
                .build();

        SimpleTrigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("trigger1_1", "tGroup1")
                .startNow()
                .withSchedule(
                        SimpleScheduleBuilder
                                .repeatSecondlyForever(2)
                                .withRepeatCount(5)
                )
                .forJob(jobDetail)
                .build();


        Trigger trigger2 = TriggerBuilder
                .newTrigger()
                .withIdentity("trigger1_2", "tGroup1")
                .startNow()
                .forJob(jobDetail)
                .build();

        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();
        scheduler.addJob(jobDetail, true);
        scheduler.scheduleJob(trigger);
        scheduler.scheduleJob(trigger2);
        scheduler.start();
        Thread.sleep(30L * 1000L);
        System.out.println("Shut down " + scheduler.getSchedulerName() + " at " + new Date());
        scheduler.shutdown(true);
    }
}
