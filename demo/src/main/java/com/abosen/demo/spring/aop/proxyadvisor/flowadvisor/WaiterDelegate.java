package com.abosen.demo.spring.aop.proxyadvisor.flowadvisor;

import com.abosen.demo.spring.aop.proxyadvisor.Waiter;

/**
 * @author qiubaisen
 * @date 2018/10/23
 */
public class WaiterDelegate {
    private Waiter waiter;

    public void service(String name) {
        waiter.greetTo(name);
        waiter.serveTo(name);
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }
}
