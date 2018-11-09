package com.abosen.demo.spring.quartz.basic;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;

import java.time.LocalDate;
import java.util.*;
import java.util.Calendar;

/**
 * @author qiubaisen
 * @date 2018/11/8
 */
public class CalendarExample {
    public static void main(String[] args) throws Exception {
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();

        // 按年为周期
        AnnualCalendar holidays = new AnnualCalendar();

        // 设置劳动节
        Calendar laborDay = Calendar.getInstance();
        laborDay.set(Calendar.MONTH, Calendar.MAY);
        laborDay.set(Calendar.DATE, 1);

        // 设置国庆节
        GregorianCalendar nationalDay = new GregorianCalendar();
        nationalDay.set(Calendar.MONTH, Calendar.OCTOBER);
        nationalDay.set(Calendar.DATE, 1);

        // 设置今天不干活
        LocalDate now = LocalDate.now();
        GregorianCalendar today = new GregorianCalendar();
        today.set(Calendar.MONTH, now.getMonthValue() - 1);
        today.set(Calendar.DATE, now.getDayOfMonth());

        // 排除掉这两个假期
        ArrayList<Calendar> calendars = new ArrayList<>(Arrays.asList(laborDay, nationalDay));

        holidays.setDaysExcluded(calendars);
        scheduler.addCalendar("holidays", holidays, false, false);

        calendars.add(today);
        holidays.setDaysExcluded(calendars);
        scheduler.addCalendar("lazy", holidays, false, false);

        // 放假
        JobDetail jobDetail = JobBuilder.newJob(SimpleJob.class)
                .withIdentity("job1", "group1")
                .build();

        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(
                        SimpleScheduleBuilder.repeatSecondlyForever(2)
                )
                .modifiedByCalendar("holidays")
                .build();

        // 今天不上班
        // 不会被触发
        JobDetail jobDetail2 = JobBuilder.newJob(SimpleJob.class)
                .withIdentity("job2", "group2")
                .build();

        SimpleTrigger trigger2 = TriggerBuilder.newTrigger()
                .withIdentity("trigger2", "group2")
                .withSchedule(
                        SimpleScheduleBuilder.repeatSecondlyForever(2)
                )
                .modifiedByCalendar("lazy")
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.scheduleJob(jobDetail2, trigger2);

        scheduler.start();

        Thread.sleep(30L * 1000L);
        System.out.println("Shut down " + scheduler.getSchedulerName() + " at " + new Date());
        scheduler.shutdown(true);
    }
}
