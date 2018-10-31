package com.abosen.demo.spring.aop.aspectj.argsusage;

import org.springframework.stereotype.Component;

/**
 * @author qiubaisen
 * @date 2018/10/30
 */

@Component
public class InheritBeanAnnoUnderParamType {
    /**
     * 1. 可继承的注解
     * 2. 注解点低于参数类型
     */
    public void funT(T1 t1) {
        t1.print();
    }

    @Component("t0_under")
    public class T0 {
        public void print() {
            InheritM annotation = this.getClass().getAnnotation(InheritM.class);
            System.out.println(
                    String.format("%s %s annotated with %s",
                            getClass().getSimpleName(),
                            annotation == null ? "do not " : "",
                            InheritM.class.getSimpleName()));        }
    }
    @Component("t1_under")
    public class T1 extends T0 {
    }

    @InheritM
    @Component("t2_under")
    public class T2 extends T1 {
    }
    @Component("t3_under")
    public class T3 extends T2 {
    }


}

