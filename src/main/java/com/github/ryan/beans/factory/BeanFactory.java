package com.github.ryan.beans.factory;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * 解决 IoC 容器在 已经获取 Bean 的定义的情况下，如何装配、获取 Bean 实例 的问题
 * 使用工厂模式：
 * 工厂负责创建bean实例，并提供接口让用户获取需要的实例对象，至于实例对象如何创建，实例对象依赖的属性如何管理，
 * 用户无需关心。工厂本身是纯虚构原则创建出来的类，负责bean实例创建，符合SRP原则
 * @className: BeanFactory
 * @date May 09,2017
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;

    // void registerBeanDefinition(String name, BeanDefinition definition) throws Exception;
}
