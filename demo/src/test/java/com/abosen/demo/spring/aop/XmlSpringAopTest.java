package com.abosen.demo.spring.aop;

import com.abosen.demo.spring.aop.springaop.ForumService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

/**
 * @author qiubaisen
 * @date 2018/9/27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/aop/spring-aop.xml")
public class XmlSpringAopTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Test(expected = SQLException.class)
    public void testThrowAdvice() throws SQLException {
        // forumService 是一个FactoryBean 在取bean的时候，会去工厂里拿，这里拿到了我们要的代理
        ForumService forumService = (ForumService) applicationContext.getBean("forumService");
        forumService.updateIndex();     // 不会被增强
        forumService.removeAllUser();   // 增强事务
    }
}
