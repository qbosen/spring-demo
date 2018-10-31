package com.abosen.demo.spring.aop.aspectj.argsusage;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author qiubaisen
 * @date 2018/10/30
 */
@Aspect
@Component
public class ArgsAnnotationAspect {
    @Before("@args(M)")
    public void beforeMArgs(JoinPoint joinPoint) {
        System.out.println(String.format("%10s %s  args: %s", "@M", joinPoint.toShortString(), joinPoint.getArgs()[0].getClass().getSimpleName()));
    }

    @Before("@args(InheritM)")
    public void beforeInheritMArgs(JoinPoint joinPoint) {
        System.out.println(String.format("%10s %s  args: %s", "@InheritM", joinPoint.toShortString(), joinPoint.getArgs()[0].getClass().getSimpleName()));
    }


}
