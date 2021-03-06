package com.github.ryan.aop;

/**
 * Delegate interface for a configured AOP proxy, allowing for the creation
 * of actual proxy object.
 *
 * Out-of-the-box implementations are available for JDK dynamic proxies
 * and for CGLIB proxies, as applied by DefaultAopProxyFactory
 *
 * @description: AOP代理（织入）
 * 策略接口：
 * 生成代理对象时，可以使用 JDK 的动态代理和 Cglib 的动态代理，对于不同的需求可以委托给不同的类实现
 *
 * @className: AopProxy
 * @date November 30,2017
 */
public interface AopProxy {

    // 获取代理后的对象
    Object getProxy();

}
