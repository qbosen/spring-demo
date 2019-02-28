package com.abosen.demo.spring.aop.aspectj.anno.main;

import com.abosen.demo.spring.aop.aspectj.anno.StaticMethodHello;
import org.springframework.context.annotation.*;

/**
 * @author qiubaisen
 * @date 2019-02-27
 */
public class StaticInterceptTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
        StaticMethodHello.hello();
    }
}
@Configuration
@EnableLoadTimeWeaving
class TestConfig {
}
