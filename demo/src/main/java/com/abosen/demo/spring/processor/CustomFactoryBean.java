package com.abosen.demo.spring.processor;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author abosen
 * @date 2018/9/17
 */
public class CustomFactoryBean implements FactoryBean<InfoBean> {
    @Override
    public InfoBean getObject() throws Exception {
        InfoBean infoBean = new InfoBean();
        infoBean.setName("made by factory");
        infoBean.setAge(2);
        return infoBean;
    }

    @Override
    public Class<?> getObjectType() {
        return InfoBean.class;
    }

}
