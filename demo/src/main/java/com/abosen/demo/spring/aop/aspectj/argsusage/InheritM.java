package com.abosen.demo.spring.aop.aspectj.argsusage;

import java.lang.annotation.*;

/**
 * @author qiubaisen
 * @date 2018/10/30
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface InheritM {
}
