package com.abosen.demo.spring.aop.aspectj.beans;

/**
 * @author qiubaisen
 * @date 2018/10/29
 */
public class WaiterManager {
    public void addWaiter(Waiter waiter) {
        System.out.println("add Waiter...");
    }

    public void addNaiveWaiter(NaiveWaiter nw) {
        System.out.println("add NaiveWaiter...");
    }
}