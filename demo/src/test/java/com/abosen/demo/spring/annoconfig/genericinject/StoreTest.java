package com.abosen.demo.spring.annoconfig.genericinject;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

/**
 * @author abosen
 * @date 2018/9/20
 */
public class StoreTest {
    @Test
    public void testGenericInject() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnoConfig.class);
        Tmall bean = applicationContext.getBean(Tmall.class);
        /*这里判断类型后 又根据名称取bean。 如果仅通过类型获取，当有多个选择时会抛出异常*/
        System.out.println(bean);
    }
}