package com.github.ryan.aop;

import java.lang.reflect.Method;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: MethodMatcher
 * @date December 01,2017
 */
public interface MethodMatcher {

    // 判断是否对某个对象的某个方法进行拦截
    boolean matches(Method method, Class targetClass);

}
