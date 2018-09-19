package com.abosen.demo.spring.annoconfig.beans;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author abosen
 * @date 2018/9/19
 */

@Data
@Component
public class BeanCollection {

    @Autowired
    private SimpleBean[] simpleBeansArr;

    @Autowired
    private Set<SimpleBean> simpleBeansSet;

    @Autowired
    private List<SimpleBean> simpleBeanList;

    @Autowired
    private Map<String, SimpleBean> simpleBeanMap;

}
