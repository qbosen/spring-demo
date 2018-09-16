package com.abosen.demo.spring.contextaware;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author abosen
 * @date 2018/9/14
 */
public class ApplicationContextAwareDemoTest {
    @Test
    public void testAware() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/contextaware/context-aware.xml");
        Object simpleBean = ApplicationContextAwareDemo.getApplicationContext().getBean("simpleBean");
        assertNotNull(simpleBean);
    }

    @Test
    public void defaultNamingTest() {
        /*
         * xml配置的bean 默认名称是 全量名+编号
         * 注解扫描的bean 默认名称为 首字母小写的类名
         *
         * OUTPUT:
         * simpleBeanWithAnnotation
         * com.abosen.demo.spring.contextaware.SimpleBeanWithXml#0
         */
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/contextaware/context-aware.xml");
        for (String beanDefinitionName : ApplicationContextAwareDemo.getApplicationContext().getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

    }
}