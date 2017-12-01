package com.github.ryan.aop;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: ClassFilter
 * @date December 01,2017
 */
public interface ClassFilter {

    boolean matches(Class targetClass);

}
