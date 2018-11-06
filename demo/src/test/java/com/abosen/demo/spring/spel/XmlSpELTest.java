package com.abosen.demo.spring.spel;

import com.abosen.demo.spring.aop.slefproxy.MyConfiguration;
import com.abosen.demo.spring.spel.anno.MyDataSource;
import com.abosen.demo.spring.spel.xml.NumberGuess;
import com.abosen.demo.spring.spel.xml.SystemPropertyBean;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author qiubaisen
 * @date 2018/11/6
 */
public class XmlSpELTest {

    private static ApplicationContext applicationContext;

    @BeforeClass
    public static void initContext() {
        applicationContext = new ClassPathXmlApplicationContext("spring/spel/spel.xml");
    }

    @Test
    public void testInjectNumber() {
        NumberGuess bean = applicationContext.getBean(NumberGuess.class);
        assertTrue(bean != null && (Integer) bean.getRandomNumber() instanceof Integer);
    }

    @Test
    public void testSystemProperties() {
        SystemPropertyBean bean = applicationContext.getBean(SystemPropertyBean.class);
        System.out.println(bean);
        assertNotNull(bean);
    }

    @Test
    public void testAnnoValues() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyDataSource.class);
        MyDataSource bean = context.getBean(MyDataSource.class);
        System.out.println(bean);
    }

}
