package com.github.ryan.ioc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ryan.houyl@gmail.com
 * @description: 解决 IoC 容器在 已经获取 Bean 的定义的情况下，如何装配、获取 Bean 实例 的问题
 * @className: BeanFactory
 * @date May 08,2017
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}
