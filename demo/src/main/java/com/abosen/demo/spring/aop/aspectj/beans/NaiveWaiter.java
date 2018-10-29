package com.abosen.demo.spring.aop.aspectj.beans;

/**
 * @author qiubaisen
 * @date 2018/10/29
 */
public class NaiveWaiter implements Waiter{
    @Override
    public void greetTo(String clientName) {
        System.out.println("NativeWaiter greet to " + clientName + " ...");
    }

    @Override
    public void serveTo(String clientName) {
        System.out.println("NativeWaiter serve to " + clientName + " ...");
    }
}
