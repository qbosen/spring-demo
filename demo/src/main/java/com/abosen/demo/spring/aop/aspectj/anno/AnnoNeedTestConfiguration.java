package com.abosen.demo.spring.aop.aspectj.anno;

import com.abosen.demo.spring.aop.aspectj.beans.NaiveWaiter;
import com.abosen.demo.spring.aop.aspectj.beans.NaughtyWaiter;
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
public class AnnoNeedTestConfiguration {
    @Bean
    public AnnoNeedTestAspect aspect() {
        return new AnnoNeedTestAspect();
    }

    @Bean
    public Waiter naiveWaiter() {
        return new NaiveWaiter();
    }

    @Bean
    public Waiter naughtyWaiter() {
        return new NaughtyWaiter();
    }
}
