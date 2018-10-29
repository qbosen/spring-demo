package com.abosen.demo.spring.aop.aspectj;

import com.abosen.demo.spring.aop.aspectj.base.NativeWaiter;
import com.abosen.demo.spring.aop.aspectj.base.PreGreetingAspect;
import com.abosen.demo.spring.aop.aspectj.base.Waiter;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * @author qiubaisen
 * @date 2018/10/29
 */
public class AspectJProxyTest {
    @Test
    public void baseProxyTest() {
        Waiter waiter = new NativeWaiter();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(waiter);
        proxyFactory.addAspect(PreGreetingAspect.class);
        Waiter proxy = proxyFactory.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("John");
    }
}
