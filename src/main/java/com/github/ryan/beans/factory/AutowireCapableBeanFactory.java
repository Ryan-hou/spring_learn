package com.github.ryan.beans.factory;

import com.github.ryan.beans.BeanDefinition;
import com.github.ryan.BeanReference;
import com.github.ryan.beans.PropertyValue;

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
        beanDefinition.setBean(bean);
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
            // Spring本身使用了setter来进行注入，这里为了代码简洁，我们使用Field的形式来注入。
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
               BeanReference beanReference = (BeanReference) value;
               value = getBean(beanReference.getName());
            }
            declaredField.set(bean, value);
        }
    }
}
