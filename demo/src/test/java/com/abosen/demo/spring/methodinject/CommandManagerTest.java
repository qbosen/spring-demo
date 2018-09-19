package com.abosen.demo.spring.methodinject;

import com.abosen.demo.spring.methodinject.awarecontext.CommandManager;
import com.abosen.demo.spring.methodinject.lookup.AnnoConfig;
import com.abosen.demo.spring.methodinject.lookup.CommandManager2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author abosen
 * @date 2018/9/19
 */
public class CommandManagerTest {

    @Test
    public void testInjectByContext() {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring/methodinject/inject.xml");
        CommandManager commandManager = applicationContext.getBean(CommandManager.class);
        commandManager.process("cd ..");
        commandManager.process("ls -a");
        commandManager.process("rm -rf /");
    }

    @Test
    public void testLookupInject() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnoConfig.class);
        CommandManager2 commandManager = applicationContext.getBean(CommandManager2.class);
        commandManager.process("cd ..");
        commandManager.process("ls -a");
        commandManager.process("rm -rf /");
    }


}