package com.abosen.demo.spring.aop.aspectj.introduct;

import com.abosen.demo.spring.aop.aspectj.beans.NaiveWaiter;
import com.abosen.demo.spring.aop.aspectj.beans.Waiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author qiubaisen
 * @date 2018/10/29
 */

@Configuration
@EnableAspectJAutoProxy
public class IntroduceAspectConfiguration {
    @Bean
    public Waiter waiter() {
        return new NaiveWaiter();
    }

    @Bean
    public EnableSellerAspect sellerIntroduceAspect() {
        return new EnableSellerAspect();
    }
}
