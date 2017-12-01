package com.github.ryan.aop;

import lombok.Setter;
import org.aopalliance.aop.Advice;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: AspectJExpressionPointcutAdvisor
 * @date December 01,2017
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    private AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();

    @Setter
    private Advice advice;

    public void setExprssion(String exprssion) {
        this.pointcut.setExpression(exprssion);
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
