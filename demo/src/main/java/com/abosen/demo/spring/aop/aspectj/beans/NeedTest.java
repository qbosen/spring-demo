package com.abosen.demo.spring.aop.aspectj.beans;

import java.lang.annotation.*;

/**
 * @author qiubaisen
 * @date 2018/10/29
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface NeedTest {
    boolean value() default true;
}
