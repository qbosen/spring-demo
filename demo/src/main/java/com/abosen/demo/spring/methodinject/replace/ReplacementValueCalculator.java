package com.abosen.demo.spring.methodinject.replace;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @author abosen
 * @date 2018/9/19
 */
public class ReplacementValueCalculator implements MethodReplacer {

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        String input = (String) args[0];
        return "HACK: " + input;
    }
}
