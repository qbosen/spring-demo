package com.abosen.demo.spring.aop.selfproxy;

import com.abosen.demo.spring.aop.slefproxy.MyConfiguration;
import com.abosen.demo.spring.aop.slefproxy.Teacher;
import com.abosen.demo.spring.aop.slefproxy.TeacherAware;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author qiubaisen
 * @date 2018/10/26
 */
public class AopAwareTest {
    @Test
    public void autoProxy() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfiguration.class);
        Teacher teacher = applicationContext.getBean(Teacher.class);

        teacher.greetTo("John");        // 只有外部调用被aop了
        /**
         * 方法的内部调用，不会使用增加的代理类，而是直接调用原类的方法
         */
    }

    @Test
    public void awareProxyTest() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfiguration.class);
        TeacherAware teacher = applicationContext.getBean(TeacherAware.class);

        teacher.greetTo("John");        // 内部调用通过代理进行
    }

}
