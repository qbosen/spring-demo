package com.abosen.demo.spring.aop.proxyadvisor.staticmethod;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author qiubaisen
 * @date 2018/10/23
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(target.getClass().getName() + "." + method.getName());
        String clientName = (String) args[0];
        System.out.println("Hi, Mr." + clientName + ".");
    }
}
