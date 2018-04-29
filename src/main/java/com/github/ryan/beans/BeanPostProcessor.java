package com.github.ryan.beans;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: BeanPostProcessor
 * @date December 04,2017
 */
public interface BeanPostProcessor {


    Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception;

    /**
     * 方法中返回了一个 Bean，这个返回的 Bean 可能已经不是原来传入的 Bean 了，这为实现 AOP 的代理提供了可能！
     * 以 JDK 提供的动态代理为例，假设方法要求传入的对象实现了 IObj 接口，实际传入的对象是 Obj，
     * 那么在方法中，通过动态代理，可以生成一个实现了 IObj 接口并把 Obj 作为内置对象的代理类 Proxy 返回，
     * 此时 Bean 已经被偷偷换成了它的代理类。
     *
     * @param bean
     * @param beanName
     * @return
     * @throws Exception
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws Exception;
}
