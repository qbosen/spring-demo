package com.abosen.demo.spring.aop.proxyadvisor;

/**
 * @author qiubaisen
 * @date 2018/10/23
 */
public class Waiter {
    public void greetTo(String name) {
        System.out.println("waiter greet to " + name + " ...");
    }

    public void serveTo(String name) {
        System.out.println("waiter serve to " + name + " ...");
    }
}
