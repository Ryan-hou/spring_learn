package com.github.ryan.aop;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: ClassFilter
 * @date December 01,2017
 */
public interface ClassFilter {

    // 判断是否对某个对象进行拦截
    boolean matches(Class targetClass);

}
