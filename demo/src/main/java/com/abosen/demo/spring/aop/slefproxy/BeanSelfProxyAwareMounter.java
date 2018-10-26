package com.abosen.demo.spring.aop.slefproxy;

import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author qiubaisen
 * @date 2018/10/26
 */

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class BeanSelfProxyAwareMounter implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Map<String, BeanSelfProxyAware> proxyAwareMap = applicationContext.getBeansOfType(BeanSelfProxyAware.class);
        for (BeanSelfProxyAware proxyAware : proxyAwareMap.values()) {
            proxyAware.proxySelf(proxyAware);
            System.out.println(String.format("[%s] 已觉醒", AopUtils.getTargetClass(proxyAware).getSimpleName()));
        }
    }
}
