package com.github.ryan.ioc;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ryan.houyl@gmail.com
 * @description: 解决 Bean 的具体定义问题
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

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
