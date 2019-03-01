package com.abosen.demo.spring.generic;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.function.Supplier;

/**
 * @author qiubaisen
 * @date 2019-02-28
 */
public class ReflectTypeResolve {
    class InnerClass implements Itf<String> {
    }

    static class StaticInnerClass implements Itf<String> {
    }

    @Test
    public void testScope() {
        class MethodInnerClass implements Itf<Integer> {
        }
        Supplier lambdaFunc = () -> 1L;

        getTypeInfo(NormalClass.class);
        getTypeInfo(InnerClass.class);
        getTypeInfo(StaticInnerClass.class);
        getTypeInfo(MethodInnerClass.class);
        getTypeInfo(lambdaFunc.getClass());

    }

    void getTypeInfo(Class<?> clazz) {
        Type genericInterface = clazz.getGenericInterfaces()[0];
        if (genericInterface instanceof ParameterizedType) {
            Type actualTypeArgument = ((ParameterizedType) genericInterface).getActualTypeArguments()[0];
            System.out.println(clazz.getSimpleName() + "actualType:" + actualTypeArgument.getTypeName());
        } else {
            System.out.println(clazz.getSimpleName() + " not parameterized type");
        }
    }

}

class NormalClass implements Itf<String> {
}

interface Itf<T> {
}
