package com.abosen.demo.spring.aop.proxyadvisor.staticmethod;

import com.abosen.demo.spring.aop.proxyadvisor.Waiter;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * @author qiubaisen
 * @date 2018/10/23
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        // 方法切点，匹配 waiter 的 greetTo 方法
        return "greetTo".equals(method.getName());
    }

    @Override
    public ClassFilter getClassFilter() {
        // 类切点
        return (clazz) -> Waiter.class.getName().equals(clazz.getName());
    }
}
