package com.abosen.demo.spring.annoconfig.genericinject;

import java.util.Random;

/**
 * @author abosen
 * @date 2018/9/20
 */
public class StringStore implements Store<String> {
    private Random random = new Random();
    private int beanId;

    @Override
    public String sell() {
        int i = random.nextInt('z' - 'a' + 1);
        return String.valueOf(i + 'a');
    }

    public StringStore(int beanId) {
        this.beanId = beanId;
    }

    @Override
    public String toString() {
        return "StringStore{ " + beanId + " }";
    }
}
