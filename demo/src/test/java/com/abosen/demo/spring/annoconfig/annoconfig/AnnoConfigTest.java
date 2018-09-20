package com.abosen.demo.spring.annoconfig.annoconfig;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author abosen
 * @date 2018/9/18
 */
public class AnnoConfigTest {

    @Test
    public void getSimpleBeanFromPureAnnotation() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnoConfig.class);
        System.out.println(applicationContext.getBean("simpleBean"));
    }

    @Test
    public void getSimpleBeanFromDualConfigurations() {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring/annoconfig/XMLConfig.xml");
        System.out.println(applicationContext.getBean("simpleBean"));
    }
}