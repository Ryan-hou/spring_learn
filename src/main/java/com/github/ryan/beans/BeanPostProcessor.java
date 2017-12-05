package com.github.ryan.beans;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: BeanPostProcessor
 * @date December 04,2017
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception;

    Object postProcessAfterInitialization(Object bean, String beanName) throws Exception;
}
