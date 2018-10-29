package com.abosen.demo.spring.aop.aspectj.beans;

/**
 * @author qiubaisen
 * @date 2018/10/29
 */
public interface Waiter {
    @NeedTest
    void greetTo(String clientName);

    void serveTo(String clientName);
}
