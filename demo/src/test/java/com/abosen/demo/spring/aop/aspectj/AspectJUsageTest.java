package com.abosen.demo.spring.aop.aspectj;

import com.abosen.demo.spring.aop.aspectj.anno.AnnoNeedTestConfiguration;
import com.abosen.demo.spring.aop.aspectj.beans.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author qiubaisen
 * @date 2018/10/29
 */
public class AspectJUsageTest {
    @Test
    public void annotationAspectTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnoNeedTestConfiguration.class);
        Waiter naiveWaiter = (Waiter) applicationContext.getBean("naiveWaiter");
        Waiter naughtyWaiter = (Waiter) applicationContext.getBean("naughtyWaiter");

        naiveWaiter.greetTo("John");
        naiveWaiter.serveTo("John");
        naughtyWaiter.greetTo("Tom");
        naughtyWaiter.serveTo("Tom");

    }
}
