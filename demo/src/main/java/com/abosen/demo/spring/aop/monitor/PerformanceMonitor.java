package com.abosen.demo.spring.aop.monitor;

/**
 * @author qiubaisen
 * @date 2018/9/27
 */
public class PerformanceMonitor {
    private static ThreadLocal<MethodPerformance> performanceContext = new ThreadLocal<>();

    public static void begain(String info) {
        System.out.println("begin monitor...");
        MethodPerformance performance = new MethodPerformance(info);
        performanceContext.set(performance);
    }

    public static void end() {
        System.out.println("end monitor...");
        performanceContext.get().printPerformance();
    }
}
