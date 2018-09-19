package com.abosen.demo.spring.methodinject.lookup;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author abosen
 * @date 2018/9/19
 */

@Configuration
@ComponentScan
public class AnnoConfig {
    //没有指定路径扫描，将会扫描使用此注解的包
}
