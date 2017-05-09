package com.github.ryan.ioc;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ryan.houyl@gmail.com
 * @description bean的内容及元数据，保存在BeanFactory中，包装bean的实体
 * @className: BeanDefinition
 * @date May 08,2017
 */
public class BeanDefinition {

    @Getter @Setter
    private Object bean;

    @Setter @Getter
    private Class beanClass;

    @Getter
    private String beanClassName;

    @Setter @Getter
    private PropertyValues propertyValues = new PropertyValues();

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
