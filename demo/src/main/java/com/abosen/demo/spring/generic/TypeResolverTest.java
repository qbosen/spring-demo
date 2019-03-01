package com.abosen.demo.spring.generic;

import net.jodah.typetools.TypeResolver;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.GenericTypeResolver;

import java.util.AbstractList;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author qiubaisen
 * @date 2019-02-28
 */
public class TypeResolverTest {

    @Test
    public void subInterfaceGenericType() {
        class MyConsumer implements Function<Integer, String> {
            @Override
            public String apply(Integer integer) {
                return integer.toString();
            }
        }
        Class<?>[] classes = GenericTypeResolver.resolveTypeArguments(MyConsumer.class, Function.class);
        Assert.assertSame(Integer.class, classes[0]);
        Assert.assertSame(String.class, classes[1]);
    }

    @Test
    public void subClassGenericType() {
        class MyList extends AbstractList<TypeResolverTest> {
            @Override
            public TypeResolverTest get(int index) {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }
        }

        Class<?> clazz = GenericTypeResolver.resolveTypeArgument(MyList.class, AbstractList.class);
        Assert.assertSame(TypeResolverTest.class, clazz);
    }

    @Test
    public void lambdaGenericType() {
        Comparator<String> comparator = String::compareToIgnoreCase;
        Class<?>[] classes = GenericTypeResolver.resolveTypeArguments(comparator.getClass(), Consumer.class);
        Assert.assertNull(classes);
        System.out.println("org.springframework.core.GenericTypeResolver.resolveTypeArguments can't resolve types in lambda function");
    }

    @Test
    public void lambdaGenericType2() {
        Comparator<String> comparator = String::compareToIgnoreCase;
        Class<?> typeArg = TypeResolver.resolveRawArgument(Comparator.class, comparator.getClass());
        Assert.assertSame(String.class,typeArg);
    }


}
