package com.abosen.demo.spring.processor;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author abosen
 * @date 2018/9/17
 */
public class PostProcessorTest {
    @Test
    public void testPostProcessor() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring/processor/processor.xml");

    }
}