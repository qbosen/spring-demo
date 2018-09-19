package com.abosen.demo.spring.methodinject.awarecontext;

import lombok.Setter;

/**
 * @author abosen
 * @date 2018/9/19
 */

@Setter
public class Command {
    private String codes;

    public Object execute() {
        System.out.println(String.format("Running: %s\t%s", this, codes));
        return null;
    }
}
