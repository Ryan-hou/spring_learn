package com.github.ryan.ioc.factory;

import com.github.ryan.ioc.BeanDefinition;
import com.github.ryan.ioc.PropertyValue;

import java.lang.reflect.Field;

/**
 * @author ryan.houyl@gmail.com
 * @description: 可自动装配内容的BeanFactory
 * @className: AutowireCapableBeanFactory
 * @date May 09,2017
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    protected void applyPropertyValues(Object bean, BeanDefinition mbd) throws Exception {
        for (PropertyValue propertyValue : mbd.getPropertyValues().getPropertyValues()) {
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            declaredField.set(bean, propertyValue.getValue());
        }
    }
}
