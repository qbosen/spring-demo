package com.abosen.demo.spring.methodinject.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author abosen
 * @date 2018/9/19
 */
@Component
public class CommandManager2 {

    @Autowired
    private ApplicationContext applicationContext;

    public Object process(String codes) {
        Command2 command = createCommand();
        command.setCodes(codes);
        return command.execute();
    }

    @Lookup
    protected Command2 createCommand() {
        // 将会被重写。可以设为抽象方法
        return null;
    }
}
