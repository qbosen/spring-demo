package com.abosen.demo.spring.aop;

import com.abosen.demo.spring.aop.jdkproxy.Calculate;
import com.abosen.demo.spring.aop.jdkproxy.Calculator;
import com.abosen.demo.spring.aop.jdkproxy.PerformanceHandler;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiubaisen
 * @date 2018/9/27
 */
public class ProxyAopTest {
    @Test
    public void testJdkProxyAop() {
        Calculate calculate = new Calculator();
        PerformanceHandler performanceHandler = new PerformanceHandler(calculate);
        Calculate proxy = (Calculate) performanceHandler.getProxy();
        proxy.simpleCalc();
        proxy.complexCalc();
    }
}