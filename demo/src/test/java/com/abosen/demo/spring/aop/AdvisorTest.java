package com.abosen.demo.spring.aop;

import com.abosen.demo.spring.aop.proxyadvisor.Seller;
import com.abosen.demo.spring.aop.proxyadvisor.Waiter;
import com.abosen.demo.spring.aop.proxyadvisor.staticmethod.GreetingAdvisor;
import com.abosen.demo.spring.aop.proxyadvisor.staticmethod.GreetingBeforeAdvice;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author qiubaisen
 * @date 2018/10/23
 */
public class AdvisorTest {
    @Test
    public void testStaticMethodAdvisor() {
        // 生成增强，设置切面
        GreetingBeforeAdvice beforeAdvice = new GreetingBeforeAdvice();
        GreetingAdvisor advisor = new GreetingAdvisor();
        advisor.setAdvice(beforeAdvice);

        // waiter的代理
        ProxyFactory waiterProxyFactory = new ProxyFactory(new Waiter());
        waiterProxyFactory.addAdvisor(advisor);

        // seller的代理
        ProxyFactory sellerProxyFactory = new ProxyFactory(new Seller());
        sellerProxyFactory.addAdvisor(advisor);

        // 测试waiter
        Waiter waiter = (Waiter) waiterProxyFactory.getProxy();
        waiter.greetTo("James");        // greetTo 被增强
        waiter.serveTo("Yao");          // serveTo 没有被增强, 方法过滤

        Seller seller = (Seller) sellerProxyFactory.getProxy();
        seller.greetTo("Jacky Ma");     // greetTo 没有被增强， 类过滤
    }

    @Test
    public void xmlConfigStaticMethodAdvisor() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/aop/static-method-advisor.xml");
        Waiter waiter = (Waiter) applicationContext.getBean("waiter");
        Seller seller = (Seller) applicationContext.getBean("seller");

        waiter.greetTo("James");
        waiter.serveTo("Yao");
        seller.greetTo("Jacky Ma");
    }

    @Test
    public void xmlRegexpMethodAdvisor() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/aop/regexp-advisor.xml");
        Waiter waiter = (Waiter) applicationContext.getBean("waiter");
        Seller seller = (Seller) applicationContext.getBean("seller");

        waiter.greetTo("James");
        waiter.serveTo("Yao");
        seller.greetTo("Jacky Ma");
    }
}
