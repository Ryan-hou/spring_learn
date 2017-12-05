package com.github.ryan.aop;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: ProxyFactory
 * @date December 05,2017
 */
public class ProxyFactory extends AdvisedSupport implements AopProxy {

    @Override
    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    protected final AopProxy createAopProxy() {
        return new Cglib2AopProxy(this);
    }
}
