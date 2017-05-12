package com.github.ryan.ioc.factory;

import com.github.ryan.ioc.BeanDefinition;

/**
 * @author ryan.houyl@gmail.com
 * @description: 解决 IoC 容器在 已经获取 Bean 的定义的情况下，如何装配、获取 Bean 实例 的问题
 * @className: BeanFactory
 * @date May 09,2017
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;

    // void registerBeanDefinition(String name, BeanDefinition definition) throws Exception;
}
