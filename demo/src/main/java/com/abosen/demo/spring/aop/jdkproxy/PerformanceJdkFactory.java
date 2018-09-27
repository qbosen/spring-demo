package com.abosen.demo.spring.aop.jdkproxy;

import com.abosen.demo.spring.aop.monitor.PerformanceMonitor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author qiubaisen
 * @date 2018/9/27
 */
public class PerformanceJdkFactory implements InvocationHandler {
    private Object target;

    public PerformanceJdkFactory(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String info = target.getClass().getName() + "." + method.getName();
        PerformanceMonitor.begain(info);
        Object result = method.invoke(target, args);
        PerformanceMonitor.end();
        return result;
    }
}
