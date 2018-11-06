package com.abosen.demo.spring.spel.anno;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * @author qiubaisen
 * @date 2018/11/6
 */

@Configuration
@ToString
@ImportResource(locations = {"classpath:spring/spel/loadProperties.xml"})
public class MyDataSource {

//    @Data
//    class DataSource {
        @Value("#{properties['driverClassName']}")
        private String driverClassName;

        @Value("${url}")
        private String url;

        @Value("#{properties['userName']}")
        private String userName;

        @Value("#{properties['password']}")
        private String password;

//    }
}


