package com.abosen.demo.spring.aop.aspectj.anno;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author qiubaisen
 * @date 2018/10/29
 */
@Aspect
public class AnnoNeedTestAspect {
    @AfterReturning(value = "@annotation(com.abosen.demo.spring.aop.aspectj.beans.NeedTest)")
    public void needTestDebug(JoinPoint joinPoint) {
        System.out.println(joinPoint.toShortString());
        System.out.println(joinPoint.getKind());
    }
}
