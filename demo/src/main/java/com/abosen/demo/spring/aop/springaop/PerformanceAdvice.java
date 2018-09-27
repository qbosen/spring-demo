package com.abosen.demo.spring.aop.springaop;

import com.abosen.demo.spring.aop.monitor.PerformanceMonitor;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author qiubaisen
 * @date 2018/9/27
 */
public class PerformanceAdvice implements MethodInterceptor {
    /**
     * 环绕增强
     *
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String info = invocation.getThis().getClass().getName() + "." + invocation.getMethod().getName();
        PerformanceMonitor.begain(info);
        Object proceed = invocation.proceed();
        PerformanceMonitor.end();
        return proceed;
    }
}
