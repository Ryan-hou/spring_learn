package com.github.ryan.aop;

import com.github.ryan.HelloWorldService;
import com.github.ryan.HelloWorldServiceImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: AspectJExpressionPointcutTest
 * @date December 01,2017
 */
public class AspectJExpressionPointcutTest {

    @Test
    public void testClassFilter() throws Exception {
        String expression = "execution(* com.github.ryan.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getClassFilter().matches(HelloWorldService.class);
        Assert.assertTrue(matches);
    }

    @Test
    public void testMethodInterceptor() throws Exception {
        String expression = "execution(* com.github.ryan.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getMethodMatcher().matches(HelloWorldServiceImpl.class.getDeclaredMethod("helloWorld"), HelloWorldServiceImpl.class);
        Assert.assertTrue(matches);
    }
}
