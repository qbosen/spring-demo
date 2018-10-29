package com.abosen.demo.spring.aop.aspectj;

import com.abosen.demo.spring.aop.aspectj.base.NativeWaiter;
import com.abosen.demo.spring.aop.aspectj.base.PreGreetingAspect;
import com.abosen.demo.spring.aop.aspectj.base.Waiter;
import com.abosen.demo.spring.aop.aspectj.introduct.IntroduceAspectConfiguration;
import com.abosen.demo.spring.aop.aspectj.introduct.Seller;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author qiubaisen
 * @date 2018/10/29
 */
public class AspectJProxyTest {
    @Test
    public void baseProxyTest() {
        Waiter waiter = new NativeWaiter();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(waiter);
        proxyFactory.addAspect(PreGreetingAspect.class);
        Waiter proxy = proxyFactory.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("John");
    }

    @Test
    public void xmlAnnoAwareAutoProxyTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/aop/aspectj/base-anno-aware.xml");
        Waiter waiter = applicationContext.getBean(Waiter.class);
        waiter.greetTo("John");
        waiter.serveTo("John");
    }

    @Test
    public void xmlAopSchemaAutoProxyTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/aop/aspectj/schema-base-auto-proxy.xml");
        Waiter waiter = applicationContext.getBean(Waiter.class);
        waiter.greetTo("John");
        waiter.serveTo("John");
    }

    @Test
    public void annoIntroductionTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(IntroduceAspectConfiguration.class);
        Waiter waiter = applicationContext.getBean(Waiter.class);
        waiter.serveTo("Mike");
        ((Seller) waiter).sell("beer", "Mike");
    }
}
