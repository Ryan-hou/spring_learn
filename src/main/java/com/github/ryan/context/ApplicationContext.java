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
    // central interface
    // 总体流程分析：
    /**
     1.ApplicationContext 完成了类定义的读取和加载，并注册到 BeanFactory 中去。
     2.ApplicationContext 从 BeanFactory 中寻找 BeanPostProcessor，
      注册到 BeanFactory维护的 BeanPostProcessor 列表中去。
     3.ApplicationContext 以单例的模式，通过主动调用 getBean 实例化、注入属性、然后初始化 BeanFactory 中所有的 Bean。
      由于所有的 BeanPostProcessor 都已经在第 2 步中完成实例化了，因此接下来实例化的是普通 Bean，因此普通 Bean 的初始化过程可以正常执行。
     4.调用 getBean 时，委托给 BeanFactory，此时只是简单的返回每个 Bean 单例，因为所有的 Bean 实例在第三步都已经生成了。
     */
}
