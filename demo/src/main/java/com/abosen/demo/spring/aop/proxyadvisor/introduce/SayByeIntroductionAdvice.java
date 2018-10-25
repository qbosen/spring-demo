package com.abosen.demo.spring.aop.proxyadvisor.introduce;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * @author qiubaisen
 * @date 2018/10/25
 */
public class SayByeIntroductionAdvice extends DelegatingIntroductionInterceptor implements SayBye {

    @Override
    public void sayByeTo(String name) {
        System.out.println("Say bye to " + name);
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        if (isMethodOnIntroducedInterface(mi)) {
            System.out.println(String.format("before: %s.%s", mi.getThis().getClass().getName(), mi.getMethod().getName()));
            System.out.println("Bye! Mr." + mi.getArguments()[0]);
        }
        return super.invoke(mi);
    }

}
