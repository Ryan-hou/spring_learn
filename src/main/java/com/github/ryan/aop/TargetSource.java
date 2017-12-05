package com.github.ryan.aop;

import lombok.Getter;

/**
 * @author ryan.houyl@gmail.com
 * @description: 被代理的对象
 * @className: TargetSource
 * @date November 30,2017
 */
public class TargetSource {

    @Getter
    private Class[] targetClass;
    @Getter
    private Object target;

    public TargetSource(Class[] targetClass, Object target) {
        this.targetClass = targetClass;
        this.target = target;
    }
}
