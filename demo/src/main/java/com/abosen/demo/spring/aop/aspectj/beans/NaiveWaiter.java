package com.abosen.demo.spring.aop.aspectj.beans;

/**
 * @author qiubaisen
 * @date 2018/10/29
 */
public class NaiveWaiter implements Waiter {
    @Override
    public void greetTo(String clientName) {
        System.out.println("NaiveWaiter:greet to " + clientName + " ...");
    }

    @Override
    @NeedTest
    public void serveTo(String clientName) {
        System.out.println("NaiveWaiter:serve to " + clientName + " ...");
    }

    public void smile(String clientName, int times) {
        System.out.println("NaiveWaiter:smile to  " + clientName + times + "times...");
    }
}
