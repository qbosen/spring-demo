package com.abosen.demo.spring.methodinject.awarecontext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author abosen
 * @date 2018/9/19
 */

@Service
public class CommandManager {

    @Autowired
    private ApplicationContext applicationContext;

    public Object process(String codes) {
        Command command = createCommand();
        command.setCodes(codes);
        return command.execute();
    }

    protected Command createCommand() {
        // 每次都去容器中获取实例
        return this.applicationContext.getBean("command", Command.class);
    }

}
