package com.abosen.demo.spring.aop.aspectj;

import com.abosen.demo.spring.aop.aspectj.argsusage.*;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author qiubaisen
 * @date 2018/10/30
 */
public class ArgsAnnotationTest {
    @Test
    public void notInheritAnnoOverParamTypeTest() {
        // 不可继承的注解，注解点T0高于参数类T1
        // 没有匹配到切点
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ArgsAnnotationConfiguration.class);
        NotInheritAnnoOverParamType bean = applicationContext.getBean(NotInheritAnnoOverParamType.class);
        bean.funT(bean.new T1());
        bean.funT(bean.new T2());
        bean.funT(bean.new T3());
    }

    @Test
    public void notInheritAnnoOnParamTypeTest() {
        // 不可继承的注解，注解点T1 等于 参数类T1
        // 匹配注解点所有子类：T1,T2,T3
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ArgsAnnotationConfiguration.class);
        NotInheritAnnoOnParamType bean = applicationContext.getBean(NotInheritAnnoOnParamType.class);
        bean.funT(bean.new T1());
        bean.funT(bean.new T2());
        bean.funT(bean.new T3());
    }

    @Test
    public void notInheritAnnoUnderParamTypeTest() {
        // 不可继承的注解，注解点T2 低于 参数类T1
        // 仅匹配到注解点：T2
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ArgsAnnotationConfiguration.class);
        NotInheritAnnoUnderParamType bean = applicationContext.getBean(NotInheritAnnoUnderParamType.class);
        bean.funT(bean.new T1());
        bean.funT(bean.new T2());
        bean.funT(bean.new T3());
    }

    @Test
    public void inheritNewObjectAnnoOverParamTypeTest() {
        // 可继承的注解，注解点T0高于参数类T1
        // 参数通过 new 生成
        // 匹配到参数类所有子类：T1,T2,T3
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ArgsAnnotationConfiguration.class);
        InheritNewObjectAnnoOverParamType bean = applicationContext.getBean(InheritNewObjectAnnoOverParamType.class);
        bean.funT(bean.new T1());
        bean.funT(bean.new T2());
        bean.funT(bean.new T3());
    }

    @Test
    public void inheritNewObjectAnnoOnParamTypeTest() {
        // 可继承的注解，注解点T1 等于 参数类T1
        // 参数通过 new 生成
        // 匹配注解点所有子类：T1,T2,T3
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ArgsAnnotationConfiguration.class);
        InheritNewObjectAnnoOnParamType bean = applicationContext.getBean(InheritNewObjectAnnoOnParamType.class);
        bean.funT(bean.new T1());
        bean.funT(bean.new T2());
        bean.funT(bean.new T3());
    }

    @Test
    public void inheritNewObjectAnnoUnderParamTypeTest() {
        // 可继承的注解，注解点T2 低于 参数类T1
        // 参数通过 new 生成
        // 仅匹配到注解点：T2
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ArgsAnnotationConfiguration.class);
        InheritNewObjectAnnoUnderParamType bean = applicationContext.getBean(InheritNewObjectAnnoUnderParamType.class);
        bean.funT(bean.new T1());
        bean.funT(bean.new T2());
        bean.funT(bean.new T3());
    }

    @Test
    public void inheritBeanAnnoOverParamTypeTest() {
        // 可继承的注解，注解点T0高于参数类T1
        // 参数通过 ioc 获取
        // 匹配到参数类所有子类：T1,T2,T3
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ArgsAnnotationConfiguration.class);
        InheritBeanAnnoOverParamType bean = applicationContext.getBean(InheritBeanAnnoOverParamType.class);
        bean.funT((InheritBeanAnnoOverParamType.T1) applicationContext.getBean("t1_over"));
        bean.funT((InheritBeanAnnoOverParamType.T2) applicationContext.getBean("t2_over"));
        bean.funT((InheritBeanAnnoOverParamType.T3) applicationContext.getBean("t3_over"));
    }

    @Test
    public void inheritBeanAnnoOnParamTypeTest() {
        // 可继承的注解，注解点T1 等于 参数类T1
        // 参数通过 ioc 获取
        // 匹配注解点所有子类：T1,T2,T3
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ArgsAnnotationConfiguration.class);
        InheritBeanAnnoOnParamType bean = applicationContext.getBean(InheritBeanAnnoOnParamType.class);
        bean.funT((InheritBeanAnnoOnParamType.T1) applicationContext.getBean("t1_on"));
        bean.funT((InheritBeanAnnoOnParamType.T2) applicationContext.getBean("t2_on"));
        bean.funT((InheritBeanAnnoOnParamType.T3) applicationContext.getBean("t3_on"));
    }

    @Test
    public void inheritBeanAnnoUnderParamTypeTest() {
        // 可继承的注解，注解点T2 低于 参数类T1
        // 参数通过 ioc 获取
        // 匹配注解点所有子类：T2,T3
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ArgsAnnotationConfiguration.class);
        InheritBeanAnnoUnderParamType bean = applicationContext.getBean(InheritBeanAnnoUnderParamType.class);
        bean.funT((InheritBeanAnnoUnderParamType.T1) applicationContext.getBean("t1_under"));
        bean.funT((InheritBeanAnnoUnderParamType.T2) applicationContext.getBean("t2_under"));
        bean.funT((InheritBeanAnnoUnderParamType.T3) applicationContext.getBean("t3_under"));
    }


}
