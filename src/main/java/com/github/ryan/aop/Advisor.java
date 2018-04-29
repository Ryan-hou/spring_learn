package com.github.ryan.aop;

import org.aopalliance.aop.Advice;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * Advisor可以获取一个 Advice，Advice的实现类实现具体的方法拦截，需要使用者编写，
 * 也就对应了 Spring 中的前置通知、后置通知、环切通知等
 * @className: Advisor
 * @date December 01,2017
 */
public interface Advisor {

    Advice getAdvice();

}
