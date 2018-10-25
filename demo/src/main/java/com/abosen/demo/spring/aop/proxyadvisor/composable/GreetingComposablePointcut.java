package com.abosen.demo.spring.aop.proxyadvisor.composable;

import com.abosen.demo.spring.aop.proxyadvisor.flowadvisor.WaiterDelegate;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;

/**
 * @author qiubaisen
 * @date 2018/10/24
 */
public class GreetingComposablePointcut {
    public Pointcut getIntersectionPointcut() {
        ComposablePointcut pointcut = new ComposablePointcut();
        ControlFlowPointcut flowPointcut = new ControlFlowPointcut(WaiterDelegate.class, "service");    //流程切点
        NameMatchMethodPointcut methodPointcut = new NameMatchMethodPointcut();
        methodPointcut.addMethodName("greetTo");

        return pointcut.intersection((Pointcut) flowPointcut).intersection((Pointcut) methodPointcut);      //交集
    }
}
