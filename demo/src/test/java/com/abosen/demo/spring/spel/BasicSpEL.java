package com.abosen.demo.spring.spel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import javax.security.auth.callback.PasswordCallback;

import static org.junit.Assert.assertEquals;

/**
 * @author qiubaisen
 * @date 2018/11/5
 */
public class BasicSpEL {

    private static final String HELLO_WORLD = "Hello World!";

    @Test
    public void firstTry() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression("'Hello' + ' World!'");
        String message = (String) expression.getValue();
        assertEquals(HELLO_WORLD, message);
    }

    @Test
    public void concatTest() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression("'Hello World'.concat('!')");
        String message = expression.getValue(String.class);
        assertEquals(HELLO_WORLD, message);
    }

    @Test
    public void testEvaluationContext() {
        String name = "张三";
        int age = 25;
        User user = new User(name, age);
        ExpressionParser expressionParser = new SpelExpressionParser();
        EvaluationContext evaluationContext = new StandardEvaluationContext(user);
        String elName = expressionParser.parseExpression("name").getValue(evaluationContext, String.class);
        assertEquals(name, elName);
        int elAge = expressionParser.parseExpression("age").getValue(evaluationContext, int.class);
        assertEquals(age, elAge);
    }

    @Getter
    @AllArgsConstructor
    class User {
        String name;
        int age;
    }
}
