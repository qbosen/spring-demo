package com.abosen.demo.spring.methodinject.replace;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author abosen
 * @date 2018/9/19
 */
public class MyValueCalculatorTest {

    @Test
    public void testMethodReplacement(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/methodinject/replacement.xml");
        MyValueCalculator calculator = applicationContext.getBean(MyValueCalculator.class);
        System.out.println(calculator.computeValue("abc"));
    }
}