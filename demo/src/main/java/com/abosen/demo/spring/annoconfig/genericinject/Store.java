package com.abosen.demo.spring.annoconfig.genericinject;

/**
 * @author abosen
 * @date 2018/9/20
 */

public interface Store<T> {
    T sell();
}
