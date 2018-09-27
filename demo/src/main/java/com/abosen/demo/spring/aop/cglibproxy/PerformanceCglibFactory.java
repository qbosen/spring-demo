package com.abosen.demo.spring.aop.cglibproxy;

import com.abosen.demo.spring.aop.monitor.PerformanceMonitor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author qiubaisen
 * @date 2018/9/27
 */
public class PerformanceCglibFactory implements MethodInterceptor {


    public Object getProxy(Class clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        String info = proxy.getClass().getSuperclass().getName() + "." + method.getName();
        PerformanceMonitor.begain(info);
        Object result = methodProxy.invokeSuper(proxy, args);
        PerformanceMonitor.end();
        return result;
    }
}
