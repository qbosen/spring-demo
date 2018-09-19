package com.abosen.demo.spring.methodinject.lookup;

import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

/**
 * @author abosen
 * @date 2018/9/19
 */
@Setter
@Component
@Scope(SCOPE_PROTOTYPE)
public class Command2 {
    private String codes;

    public Object execute() {
        System.out.println(String.format("Running: %s\t%s", this, codes));
        return null;
    }
}