package com.abosen.demo.spring.processor;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author abosen
 * @date 2018/9/17
 */
public class CustomFactoryBeanTest {

    @Test
    public void testFactoryBean() {
        /**
         * 直接获取是
         */
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring/processor/factory.xml");
        Object myBean = context.getBean("myBean");
        assertTrue(myBean instanceof InfoBean);
        Object bean = context.getBean("&myBean");
        assertTrue(bean instanceof CustomFactoryBean);
    }
}