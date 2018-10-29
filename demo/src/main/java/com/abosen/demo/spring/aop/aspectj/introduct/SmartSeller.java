package com.abosen.demo.spring.aop.aspectj.introduct;

/**
 * @author qiubaisen
 * @date 2018/10/29
 */
public class SmartSeller implements Seller {
    @Override
    public void sell(String goods, String clientName) {
        System.out.println(String.format("Seller sell %s to %s", goods, clientName));
    }
}
