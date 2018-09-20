package com.abosen.demo.spring.annoconfig.genericinject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author abosen
 * @date 2018/9/20
 */
@Configuration
public class AnnoConfig {
    @Bean
    public StringStore stringStore() {
        return new StringStore(1);
    }

    @Bean
    public StringStore stringStore2() {
        return new StringStore(2);
    }

    @Bean
    public IntegerStore integerStore() {
        return new IntegerStore(1);
    }

    @Bean
    public IntegerStore integerStore2() {
        return new IntegerStore(2);
    }

    @Bean
    public Tmall tmall() {
        return new Tmall();
    }
}
