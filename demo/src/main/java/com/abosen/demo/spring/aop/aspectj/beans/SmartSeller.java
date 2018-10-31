package com.abosen.demo.spring.aop.aspectj.beans;

/**
 * @author qiubaisen
 * @date 2018/10/29
 */
public class SmartSeller implements Seller {
    @Override
    public int sell(String goods,String clientName) {
        System.out.println("SmartSeller: sell "+goods +" to "+clientName+"...");
        return 100;
    }

    public void checkBill(int billId){
        if(billId == 1) throw new IllegalArgumentException("iae Exception");
        else throw new RuntimeException("re Exception");
    }
}
