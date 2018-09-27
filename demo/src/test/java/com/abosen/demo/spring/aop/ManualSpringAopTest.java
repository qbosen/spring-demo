package com.abosen.demo.spring.aop;

import com.abosen.demo.spring.aop.springaop.ForumService;
import com.abosen.demo.spring.aop.springaop.PerformanceAdvice;
import com.abosen.demo.spring.aop.springaop.ForumServiceImpl;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author qiubaisen
 * @date 2018/9/27
 */
public class ManualSpringAopTest {
    /**
     * 手动的意思是 不通过spring容器初始化代理工厂 ProxyFactory
     */
    @Test
    public void MethodInterceptorTestWithTarget() {
        // 方法环绕增强测试 使用类事例代理时自动使用CGLIB代理
        ProxyFactory proxyFactory = new ProxyFactory();     // spring 提供的代理工厂
        ForumService service = new ForumServiceImpl();      // 实例化
        proxyFactory.setTarget(service);                    // 虽然是通过接口声明，但是仍然是针对类的代理
        proxyFactory.addAdvice(new PerformanceAdvice());         // 方法环绕增强
        ForumService proxy = (ForumService) proxyFactory.getProxy();  // 生成代理
        System.out.println(proxy.getClass().getName());     // CGLIB
        proxy.updateIndex();
    }

    @Test
    public void MethodInterceptorTestWithInterface() {
        // 方法环绕增强测试 使用接口代理时自动使用jdk代理
        ProxyFactory proxyFactory = new ProxyFactory();     // spring 提供的代理工厂
        ForumService service = new ForumServiceImpl();        // 实例化
        proxyFactory.setTarget(service);                    // 设置代理目标
        proxyFactory.setInterfaces(service.getClass().getInterfaces());  // 声明通过接口代理，这里导致使用jdk代理
        proxyFactory.addAdvice(new PerformanceAdvice());         // 方法环绕增强
        ForumService proxy = (ForumService) proxyFactory.getProxy();  // 生成代理
        System.out.println(proxy.getClass().getName());     // JDK
        proxy.updateIndex();
    }

    @Test
    public void MethodInterceptorTestWithOptimize() {
        // 方法环绕增强测试 使用接口代理时+设置为优化 使用CGLIB代理
        ProxyFactory proxyFactory = new ProxyFactory();     // spring 提供的代理工厂
        ForumService service = new ForumServiceImpl();        // 实例化
        proxyFactory.setTarget(service);                    // 设置代理目标
        proxyFactory.setInterfaces(service.getClass().getInterfaces());  // 声明通过接口代理，这里导致使用jdk代理
        proxyFactory.setOptimize(true);                     // 优化代理
        proxyFactory.addAdvice(new PerformanceAdvice());         // 方法环绕增强
        ForumService proxy = (ForumService) proxyFactory.getProxy();  // 生成代理
        System.out.println(proxy.getClass().getName());     // CGLIB
        proxy.updateIndex();
    }

}