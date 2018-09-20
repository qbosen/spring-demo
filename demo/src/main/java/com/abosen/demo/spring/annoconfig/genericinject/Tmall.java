package com.abosen.demo.spring.annoconfig.genericinject;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author abosen
 * @date 2018/9/20
 */
@Setter
public class Tmall {
    @Autowired
    private Store<Integer> integerStore;
    @Autowired
    private Store<String> stringStore;
    @Autowired
    private List<Store<Integer>> storeList;
    @Autowired
    private Map<String, Store<String>> storeMap;

    @Autowired
    private Store<?> integerStore2;
    @Autowired
    private Store<?> stringStore2;
    @Autowired
    private List<Store<?>> storeList2;
    @Autowired
    private Map<String, Store<?>> storeMap2;


    @Override
    public String toString() {
        return "Tmall{" +
                "\n Store<Integer> = " + integerStore +
                "\n Store<String> = " + stringStore +
                "\n List<Store<Integer>> = " + storeList +
                "\n Map<String, Store<String>> = " + storeMap +
                "\n Store<?> = " + integerStore2 +
                "\n Store<?> = " + stringStore2 +
                "\n List<Store<?>> = " + storeList2 +
                "\n Map<String, Store<?>> = " + storeMap2 +
                '}';
    }
}
