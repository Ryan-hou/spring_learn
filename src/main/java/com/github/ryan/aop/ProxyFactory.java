package com.github.ryan.aop;

/**
 * 对照 Spring DefaultAopProxyFactory
 * Default AopProxyFactory implementation,
 * creating either a CGLIB proxy or a JDK dynamic proxy.
 *
 * Crates a CGLIB proxy if one the following is true
 * for a given AdvisedSupport instance:
 *  the "optimize" flag is set
 *  the "proxyTargetClass" flag is set
 *  no proxy interfaces have been specified
 *
 * Note that the CGLIB library classes have to be present on
 * the class path is an actual CGLIB proxy needs to be created.
 *
 * In general, specify "proxyTargetClass" to enforce a CGLIB proxy,
 * or specify one or more interfaces to use a JDK dynamic proxy.
 *
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
