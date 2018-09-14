package com.abosen.demo.spring.lifecycle;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author abosen
 * @date 2018/9/14
 */
public class SmartLifecycleDemoTest {

    @Test
    public void testLifeCycle() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/lifecycle/lifecycle.xml");
        context.getBean("lifecycle");
        context.close();
    }
}