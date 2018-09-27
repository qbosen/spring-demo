package com.abosen.demo.spring.aop.cglibproxy;

import com.abosen.demo.spring.aop.jdkproxy.Calculate;

/**
 * @author qiubaisen
 * @date 2018/9/27
 */
public class Computer {
    public void simpleCompute() {
        try {
            System.out.println("computing...");
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void complexCompute() {
        try {
            System.out.println("computing...");
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
