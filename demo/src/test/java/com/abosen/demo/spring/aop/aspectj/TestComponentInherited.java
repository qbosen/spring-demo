package com.abosen.demo.spring.aop.aspectj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.annotation.*;

import static org.junit.Assert.assertNotNull;

/**
 * @author qiubaisen
 * @date 2018/10/31
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@interface InheritComponent{}

@InheritComponent
class Parent {
}

class Child extends Parent {
}

@Configuration
@ComponentScan(includeFilters = {@ComponentScan.Filter(InheritComponent.class)})
class Config {
}

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class TestComponentInherited {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void name() throws Exception {
        Child child = applicationContext.getBean(Child.class);
        assertNotNull(child);
        Parent parent = (Parent) applicationContext.getBean("parent");
        assertNotNull(parent);
    }
}