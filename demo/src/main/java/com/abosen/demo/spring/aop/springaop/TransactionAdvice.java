package com.abosen.demo.spring.aop.springaop;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @author qiubaisen
 * @date 2018/9/27
 */
public class TransactionAdvice implements ThrowsAdvice {
    /**
     * ThrowsAdvice 是一个标签接口，其中没有任何方法。
     * 其增强方法必须遵守下列格式之一
     * public void afterThrowing(Exception ex)
     * public void afterThrowing(RemoteException)
     * public void afterThrowing(Method method, Object[] args, Object target, Exception ex)
     * public void afterThrowing(Method method, Object[] args, Object target, ServletException ex)
     */

    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
        System.out.println("------------");
        System.out.println("class: " + target.getClass().getName());
        System.out.println("method: " + method.getName());
        System.out.println("message: " + ex.getMessage());
        System.out.println("回滚事务!");
    }
}
