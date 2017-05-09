package com.github.ryan.ioc.factory;

import com.github.ryan.ioc.BeanDefinition;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: AutowireCapableBeanFactory
 * @date May 09,2017
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        try {
            Object bean = beanDefinition.getBeanClass().newInstance();
            return bean;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
