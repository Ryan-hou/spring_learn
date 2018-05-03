package com.github.ryan.aop;

import lombok.Setter;
import org.aopalliance.aop.Advice;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * 通过注入 Advice(Interceptor) 和 Pointcut expression 来实现基于方法拦截器和aspectj expression 的PointcutAdvisor
 *
 * @className: AspectJExpressionPointcutAdvisor
 * @date December 01,2017
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    // 基于AspectJ Expression的Pointcut实现
    private AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();

    @Setter
    private Advice advice;

    public void setExpression(String expression) {
        this.pointcut.setExpression(expression);
    }

    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }
}
