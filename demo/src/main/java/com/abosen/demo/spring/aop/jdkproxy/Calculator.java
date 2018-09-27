package com.abosen.demo.spring.aop.jdkproxy;

/**
 * @author qiubaisen
 * @date 2018/9/27
 */
public class Calculator implements Calculate {
    @Override
    public void simpleCalc() {
        try {
            System.out.println("calculating...");
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void complexCalc() {
        try {
            System.out.println("calculating...");
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
