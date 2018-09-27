package com.abosen.demo.spring.aop;

import com.abosen.demo.spring.aop.cglibproxy.Computer;
import com.abosen.demo.spring.aop.cglibproxy.PerformanceCglibFactory;
import com.abosen.demo.spring.aop.jdkproxy.Calculate;
import com.abosen.demo.spring.aop.jdkproxy.Calculator;
import com.abosen.demo.spring.aop.jdkproxy.PerformanceJdkFactory;
import org.junit.Test;

/**
 * @author qiubaisen
 * @date 2018/9/27
 */
public class ProxyAopTest {
    @Test
    public void testJdkProxyAop() {
        Calculate calculate = new Calculator();
        PerformanceJdkFactory factory = new PerformanceJdkFactory(calculate);
        Calculate proxy = (Calculate) factory.getProxy();
        proxy.simpleCalc();
        proxy.complexCalc();
    }

    @Test
    public void testCglibProxyAop() {
        PerformanceCglibFactory factory = new PerformanceCglibFactory();
        Computer proxy = (Computer) factory.getProxy(Computer.class);
        proxy.simpleCompute();
        proxy.complexCompute();
    }
}