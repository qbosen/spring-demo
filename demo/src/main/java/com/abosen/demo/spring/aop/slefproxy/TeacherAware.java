package com.abosen.demo.spring.aop.slefproxy;

import org.springframework.stereotype.Service;

/**
 * @author qiubaisen
 * @date 2018/10/26
 */

@Service
public class TeacherAware implements BeanSelfProxyAware {
    private TeacherAware teacher;

    @Override
    public void proxySelf(Object proxy) {
        teacher = (TeacherAware) proxy;
    }

    public void greetTo(String name) {
        System.out.println("teacher greet to " + name + " ...");
        teacher.speakTo(name);
    }

    public void speakTo(String name) {
        System.out.println("teacher speak to " + name + " ...");
    }
}
