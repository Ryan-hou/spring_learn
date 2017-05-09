package com.github.ryan.ioc;

/**
 * @author ryan.houyl@gmail.com
 * @description: 从配置中读取BeanDefinition
 * @className: BeanDefinitionReader
 * @date May 09,2017
 */
public interface BeanDefinitionReader {
    void loadBeanDefinitions(String location) throws Exception;
}
