package com.abosen.demo.spring.aop.aspectj.introduct;

import com.abosen.demo.spring.aop.aspectj.base.NativeWaiter;
import com.abosen.demo.spring.aop.aspectj.base.Waiter;
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
        return new NativeWaiter();
    }

    @Bean
    public EnableSellerAspect sellerIntroduceAspect() {
        return new EnableSellerAspect();
    }
}
