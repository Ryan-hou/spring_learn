package com.github.ryan.aop;


/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: AbstractAopProxy
 * @date December 05,2017
 */
public abstract class AbstractAopProxy implements AopProxy {

    protected AdvisedSupport advised;

    public AbstractAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }

}
