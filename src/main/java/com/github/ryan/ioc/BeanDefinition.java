package com.github.ryan.ioc;

/**
 * @author ryan.houyl@gmail.com
 * @description: 解决 Bean 的具体定义问题
 * @className: BeanDefinition
 * @date May 08,2017
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
