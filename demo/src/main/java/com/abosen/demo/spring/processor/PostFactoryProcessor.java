package com.abosen.demo.spring.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author abosen
 * @date 2018/9/17
 */
public class PostFactoryProcessor implements BeanFactoryPostProcessor {
    /**
     * 可以在容易实例化bean之前读取配置元数据 BeanDefinition
     */
    private final String infoBean = "infoBean";

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition(infoBean);
        System.out.println("beanFactory reading...");
        System.out.println(beanDefinition);
    }
}
