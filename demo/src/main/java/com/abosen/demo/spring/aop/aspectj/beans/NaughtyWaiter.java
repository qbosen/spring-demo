package com.abosen.demo.spring.aop.aspectj.beans;

/**
 * @author qiubaisen
 * @date 2018/10/29
 */
public class NaughtyWaiter implements Waiter {
    @Override
    public void greetTo(String clientName) {
        System.out.println("NaughtyWaiter:greet to " + clientName + "...");
    }

    @Override
    public void serveTo(String clientName) {
        System.out.println("NaughtyWaiter:serving " + clientName + "...");
    }

    public void joke(String clientName, int times) {
        System.out.println("NaughtyWaiter:play " + times + " jokes to " + clientName + "...");
    }
}
