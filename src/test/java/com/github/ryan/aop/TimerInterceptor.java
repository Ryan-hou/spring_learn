package com.github.ryan.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author ryan.houyl@gmail.com
 * @description: 通过Interceptor实现AOP的advice
 * @className: TimerInterceptor
 * Advice -> Interceptor -> MethodInterceptor(Object invoke(MethodInvocation invocation)) -> TimerInterceptor
 * @date November 30,2017
 */
public class TimerInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long time = System.nanoTime();
        System.out.println("Invocation of Method " + invocation.getMethod().getName() + " start!");
        Object proceed = invocation.proceed();
        System.out.println("Invocation of Method " + invocation.getMethod().getName() + " end! takes " + (System.nanoTime() - time)
            + " nanoseconds.");
        return proceed;
    }
}
