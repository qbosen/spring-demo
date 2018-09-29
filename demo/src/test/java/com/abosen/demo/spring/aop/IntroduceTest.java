package com.abosen.demo.spring.aop;

import com.abosen.demo.spring.aop.springaop.ControllablePerformanceMonitor;
import com.abosen.demo.spring.aop.springaop.ForumService;
import com.abosen.demo.spring.aop.springaop.ForumServiceImpl;
import com.abosen.demo.spring.aop.springaop.Monitorable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.PostConstruct;


/**
 * @author qiubaisen
 * @date 2018/9/29
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = IntroduceConfig.class)
public class IntroduceTest {
    private ForumService service;


    @Autowired
    ProxyFactoryBean factoryBean;

    @PostConstruct
    public void init() {
        service = (ForumService) factoryBean.getObject();
    }


    @Test
    public void monitorIntroduceTest() {
        service.updateIndex();              // 关闭
        Monitorable monitor = (Monitorable) service;
        monitor.setMonitorState(true);     // 开启监控
        service.updateIndex();
        monitor.setMonitorState(false);    // 关闭监控
        service.updateIndex();
    }

}

@Configuration
class IntroduceConfig {
    @Bean
    public ControllablePerformanceMonitor monitor() {
        return new ControllablePerformanceMonitor();
    }

    @Bean("target")
    public ForumService forumServiceTarget() {
        return new ForumServiceImpl();
    }

    @Bean("service")
    public ProxyFactoryBean forumService(ForumService target) {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setInterfaces(Monitorable.class);      // 引介实现的接口
        proxyFactoryBean.setInterceptorNames("monitor");
        proxyFactoryBean.setTarget(target);
        proxyFactoryBean.setProxyTargetClass(true);     // 引介增强必须通过创建子类，所以必须使用CGLIB
        return proxyFactoryBean;
    }

}
