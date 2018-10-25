package com.abosen.demo.spring.aop;

import com.abosen.demo.spring.aop.proxyadvisor.Seller;
import com.abosen.demo.spring.aop.proxyadvisor.Waiter;
import com.abosen.demo.spring.aop.proxyadvisor.flowadvisor.WaiterDelegate;
import com.abosen.demo.spring.aop.proxyadvisor.introduce.SayBye;
import com.abosen.demo.spring.aop.proxyadvisor.introduce.SayByeIntroductionAdvice;
import com.abosen.demo.spring.aop.proxyadvisor.staticmethod.GreetingAdvisor;
import com.abosen.demo.spring.aop.proxyadvisor.staticmethod.GreetingBeforeAdvice;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultIntroductionAdvisor;
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

    @Test
    public void xmlDynamicMethodAdvisor() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/aop/dynamic-method-advisor.xml");
        Waiter waiter = (Waiter) applicationContext.getBean("waiter");
        Seller seller = (Seller) applicationContext.getBean("seller");

        waiter.greetTo("James");
        waiter.serveTo("Yao");
        seller.greetTo("John");

        waiter.greetTo("John");     //special client
    }

    @Test
    public void xmlControlFlowMethodAdvisor() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/aop/flow-method-advisor.xml");
        Waiter waiter = (Waiter) applicationContext.getBean("waiter");
        Seller seller = (Seller) applicationContext.getBean("seller");
        WaiterDelegate delegate = (WaiterDelegate) applicationContext.getBean("waiterDelegate");
        delegate.setWaiter(waiter);

        waiter.greetTo("James");
        waiter.serveTo("Yao");
        seller.greetTo("John");
        // 由delegate调用的 greetTo, serveTo 都被增强了
        delegate.service("Peter");
    }

    @Test
    public void testComposableMethodAdvisor() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/aop/composable-pointcut.xml");
        Waiter waiter = (Waiter) applicationContext.getBean("waiter");
        Seller seller = (Seller) applicationContext.getBean("seller");
        WaiterDelegate delegate = (WaiterDelegate) applicationContext.getBean("waiterDelegate");
        delegate.setWaiter(waiter);

        waiter.greetTo("James");
        waiter.serveTo("Yao");
        seller.greetTo("John");
        // 由delegate调用的 greetTo 被增强了
        delegate.service("Peter");
    }


    @Test
    public void testJavaIntroductionAdvisor() {
        // 生成增强，设置切面
        SayByeIntroductionAdvice introductionAdvice = new SayByeIntroductionAdvice();
        DefaultIntroductionAdvisor advisor = new DefaultIntroductionAdvisor(introductionAdvice, SayBye.class) {
            @Override
            public boolean matches(Class<?> clazz) {
                return Waiter.class.isAssignableFrom(clazz);
            }
        };

        // waiter的代理
        ProxyFactory waiterProxyFactory = new ProxyFactory(new Waiter());
        waiterProxyFactory.addAdvisor(advisor);
        waiterProxyFactory.setOptimize(true);

        // seller的代理
        ProxyFactory sellerProxyFactory = new ProxyFactory(new Seller());
        sellerProxyFactory.addAdvisor(advisor);
        sellerProxyFactory.setOptimize(true);

        // 测试waiter
        Waiter waiter = (Waiter) waiterProxyFactory.getProxy();
        waiter.greetTo("James");
        waiter.serveTo("Yao");
        SayBye waiter2 = (SayBye) waiterProxyFactory.getProxy();
        waiter2.sayByeTo("Deng");                       // 引介增强


        Seller seller = (Seller) sellerProxyFactory.getProxy();
        seller.greetTo("Jacky Ma");
        SayBye seller2 = (SayBye) sellerProxyFactory.getProxy();
        if (advisor.matches(Seller.class)) {
            seller2.sayByeTo("Mike");                       // 引介切面过滤掉了
        } else {
            System.out.println(String.format("%s 没有增强 %s 接口", Seller.class.getName(), SayBye.class.getName()));
        }
    }
}
