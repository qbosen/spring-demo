package com.abosen.demo.spring.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author abosen
 * @date 2018/9/17
 */
public class PostProcessor implements BeanPostProcessor {

    private final String infoBean = "infoBean";

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (infoBean.equals(beanName)) {
            System.out.println("post before");
            System.out.println(bean);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (infoBean.equals(beanName)) {
            System.out.println("post after");
            ((InfoBean) bean).setAge(10);
            ((InfoBean) bean).setName("changed name");
            System.out.println(bean);
        }
        return bean;
    }
}
