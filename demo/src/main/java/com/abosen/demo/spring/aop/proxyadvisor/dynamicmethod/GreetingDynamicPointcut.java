package com.abosen.demo.spring.aop.proxyadvisor.dynamicmethod;

import com.abosen.demo.spring.aop.proxyadvisor.Waiter;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author qiubaisen
 * @date 2018/10/23
 */
public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut {
    // 对特殊顾客进行问候
    private static List<String> specialClientList = new ArrayList<>();

    static {
        specialClientList.add("John");
        specialClientList.add("Tom");
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        System.out.println(String.format("对方法 %s 进行静态检查", method.getName()));
        return "greetTo".equals(method.getName());
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        System.out.println(String.format("对方法 %s 进行动态检查", method.getName()));
        String clientName = (String) args[0];
        return specialClientList.contains(clientName);
    }

    @Override
    public ClassFilter getClassFilter() {
        return (clazz) -> {
            System.out.println("使用 getClassFilter() 对 " + clazz.getName() + " 进行切点的静态检查");
            return Waiter.class.isAssignableFrom(clazz);
        };
    }
}
