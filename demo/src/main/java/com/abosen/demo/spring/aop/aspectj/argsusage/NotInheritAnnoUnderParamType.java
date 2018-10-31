package com.abosen.demo.spring.aop.aspectj.argsusage;

import org.springframework.stereotype.Component;

/**
 * @author qiubaisen
 * @date 2018/10/30
 */

@Component
public class NotInheritAnnoUnderParamType {
    /**
     * 1. 不可继承的注解
     * 2. 注解点低于参数类型
     */
    public void funT(T1 t1) {
        t1.print();
    }

    public class T0 {
        public void print() {
            M annotation = this.getClass().getAnnotation(M.class);
            System.out.println(
                    String.format("%s %s annotated with %s",
                            getClass().getSimpleName(),
                            annotation == null ? "do not " : "",
                            M.class.getSimpleName()));
        }
    }

    public class T1 extends T0 {
    }

    @M
    public class T2 extends T1 {
    }

    public class T3 extends T2 {
    }


}

