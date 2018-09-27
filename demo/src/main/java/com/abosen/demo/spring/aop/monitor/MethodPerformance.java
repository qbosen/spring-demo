package com.abosen.demo.spring.aop.monitor;

/**
 * @author qiubaisen
 * @date 2018/9/27
 */
public class MethodPerformance {
    private long begin;
    private long end;
    private String info;

    public MethodPerformance(String info) {
        this.info = info;
        this.begin = System.currentTimeMillis();
    }

    public void printPerformance() {
        end = System.currentTimeMillis();
        long elapse = end - begin;
        System.out.println(info + ": " + elapse + " ms");
    }
}
