package com.github.ryan;

import com.github.ryan.beans.BeanPostProcessor;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: BeanInitializeLogger
 * @date December 04,2017
 */
public class BeanInitializeLogger implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        System.out.println("Initialize bean " + beanName + " start!");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        System.out.println("Initialize bean " + beanName + " end!");
        return bean;
    }
}
