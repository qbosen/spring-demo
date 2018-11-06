package com.abosen.demo.spring.quartz.basic;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @author qiubaisen
 * @date 2018/11/6
 */
public class SimpleJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println(context.getTrigger().getKey() + " triggered. time is " + new Date());
    }
}
