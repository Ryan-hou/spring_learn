package com.github.ryan.context;

import com.github.ryan.beans.factory.BeanFactory;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * 整合了BeanFactory，BeanDefinitionReader，Resource，解决根据地址获取IoC容器并使用的问题
 *
 * 两件事：
 * 1）容器配置，即从不同来源，不同类型的资源加载类定义（Resource／BeanDefinitionReader）
 * 2）bean的装配/获取(BeanFactory)
 *
 * @className: ApplicationContext
 * @date May 12,2017
 */
public interface ApplicationContext extends BeanFactory {
}
