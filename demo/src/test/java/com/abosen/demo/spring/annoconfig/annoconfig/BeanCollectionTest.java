package com.abosen.demo.spring.annoconfig.annoconfig;

import com.abosen.demo.spring.annoconfig.beans.BeanCollection;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author abosen
 * @date 2018/9/19
 */
public class BeanCollectionTest {
    @Test
    public void testCollectionInject() {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring/annoconfig/CollectionInjectConfig.xml");
        BeanCollection bean = applicationContext.getBean(BeanCollection.class);

        System.out.println(bean);
    }
}
