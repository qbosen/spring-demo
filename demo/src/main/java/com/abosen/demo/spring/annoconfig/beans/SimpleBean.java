package com.abosen.demo.spring.annoconfig.beans;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author abosen
 * @date 2018/9/18
 */

@Data
@Component
public class SimpleBean {
    public SimpleBean() {
        System.out.println("construction");
    }

    @Value("Annotation Initialization Bean")
    private String name;
}
