package com.abosen.demo.spring.aop.aspectj.introduct;

import com.abosen.demo.spring.aop.aspectj.beans.Seller;
import com.abosen.demo.spring.aop.aspectj.beans.SmartSeller;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * @author qiubaisen
 * @date 2018/10/29
 */

@Aspect
public class EnableSellerAspect {
    @DeclareParents(value = "com.abosen.demo.spring.aop.aspectj.beans.NaiveWaiter", defaultImpl = SmartSeller.class)
    public Seller seller;
}
