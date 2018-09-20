package com.abosen.demo.spring.annoconfig.genericinject;

import java.util.Random;

/**
 * @author abosen
 * @date 2018/9/20
 */
public class IntegerStore implements Store<Integer> {
    private Random random = new Random();
    private int beanId;

    @Override
    public Integer sell() {
        return random.nextInt(10);
    }

    public IntegerStore(int beanId) {
        this.beanId = beanId;
    }

    @Override
    public String toString() {
        return "IntegerStore{ " + beanId + " }";
    }
}
