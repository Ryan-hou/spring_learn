package com.github.ryan.aop;

import java.lang.reflect.Method;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: MethodMatcher
 * @date December 01,2017
 */
public interface MethodMatcher {

    boolean matches(Method method, Class targetClass);

}
