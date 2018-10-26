package com.abosen.demo.spring.aop.slefproxy;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author qiubaisen
 * @date 2018/10/26
 */

@Configuration
@ComponentScan
public class MyConfiguration {
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    @Bean
    public RegexpMethodPointcutAdvisor regexpMethodPointcutAdvisor() {
        RegexpMethodPointcutAdvisor regexpMethodPointcutAdvisor = new RegexpMethodPointcutAdvisor();
        regexpMethodPointcutAdvisor.setPattern(".*To.*");
        regexpMethodPointcutAdvisor.setAdvice(beforeAdvice());
        return regexpMethodPointcutAdvisor;
    }

    @Bean
    public MethodBeforeAdvice beforeAdvice() {
        return (method, args, target) -> System.out.println(target.getClass().getName() + "." + method.getName());
    }
}
