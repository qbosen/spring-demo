package com.abosen.demo.spring.aop;

import com.abosen.demo.spring.aop.proxyadvisor.Seller;
import com.abosen.demo.spring.aop.proxyadvisor.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author qiubaisen
 * @date 2018/10/25
 */
public class AutoProxyTest {
    @Test
    public void testBeanNameAutoProxyCreator() {
        /**
         * 自动代理技术会在 BeanPostProcessor 替换掉target
         */
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/aop/autoproxy/bean-name-auto-proxy.xml");
        Waiter waiter = applicationContext.getBean(Waiter.class);
        Seller seller = applicationContext.getBean(Seller.class);
        waiter.greetTo("Tom");
        seller.greetTo("Jack");
    }
}
