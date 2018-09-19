package com.abosen.demo.spring.annoconfig.annoconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author abosen
 * @date 2018/9/18
 */

@Configuration
@ComponentScan(basePackages = "com.abosen.demo.spring.annoconfig.beans")
public class AnnoConfig {

}
