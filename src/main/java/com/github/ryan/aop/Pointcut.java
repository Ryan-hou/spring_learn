package com.github.ryan.aop;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * 切点对象可以获取一个 ClassFilter 对象和一个 MethodMatcher 对象。
 * 前者用于判断是否对某个对象进行拦截（用于 筛选要代理的目标对象），
 * 后者用于判断是否对某个方法进行拦截（用于 在代理对象中对不同的方法进行不同的操作）
 * @className: Pointcut
 * @date December 01,2017
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();

}
