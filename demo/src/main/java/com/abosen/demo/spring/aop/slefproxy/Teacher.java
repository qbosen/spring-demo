package com.abosen.demo.spring.aop.slefproxy;

import org.springframework.stereotype.Service;

/**
 * @author qiubaisen
 * @date 2018/10/26
 */
@Service
public class Teacher {
    public void greetTo(String name) {
        System.out.println("teacher greet to " + name + " ...");
        speakTo(name);
    }

    public void speakTo(String name) {
        System.out.println("teacher speak to " + name + " ...");
    }
}
