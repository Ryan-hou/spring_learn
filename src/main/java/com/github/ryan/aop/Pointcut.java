package com.github.ryan.aop;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: Pointcut
 * @date December 01,2017
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();

}
