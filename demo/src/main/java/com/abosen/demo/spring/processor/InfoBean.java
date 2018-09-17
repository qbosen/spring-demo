package com.abosen.demo.spring.processor;

import lombok.Data;

/**
 * @author abosen
 * @date 2018/9/17
 */

@Data
public class InfoBean {
    private String name;
    private int age;

    public InfoBean() {
        System.out.println("constructor");
    }

    public void initBean() {
        this.name = "information";
        this.age = 5;
        System.out.println("init method");
        System.out.println(this);
    }
}
