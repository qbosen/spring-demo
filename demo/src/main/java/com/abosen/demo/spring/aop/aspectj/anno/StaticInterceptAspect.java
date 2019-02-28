package com.abosen.demo.spring.aop.aspectj.anno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author qiubaisen
 * @date 2019-02-27
 */

@Aspect
public class StaticInterceptAspect {

    @Pointcut("execution(static void com.abosen.demo.spring.aop.aspectj.anno.StaticMethodHello.hello())")
    public void staticPointCut(){
    }


    @Before("staticPointCut()")
    public void interceptStatic() {
        System.out.println("static intercept");
    }

}
