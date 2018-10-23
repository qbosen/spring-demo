package com.abosen.demo.spring.aop.proxyadvisor.flowadvisor;

import com.abosen.demo.spring.aop.proxyadvisor.Waiter;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.ControlFlowPointcut;

import java.lang.reflect.Method;

/**
 * @author qiubaisen
 * @date 2018/10/23
 */
public class GreetingFlowPointCut extends ControlFlowPointcut {
    // 本质为动态切面，动态匹配时，获取调用栈，匹配是否来自构造设置的类和方法
    public GreetingFlowPointCut(Class<?> clazz, String methodName) {
        super(clazz, methodName);
    }

    @Override
    public ClassFilter getClassFilter() {
        return (Waiter.class::isAssignableFrom);
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return "greetTo".equals(method.getName());
    }
}
