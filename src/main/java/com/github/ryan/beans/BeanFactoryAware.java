package com.github.ryan.beans;

import com.github.ryan.beans.factory.BeanFactory;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: BeanFactoryAware
 * @date December 04,2017
 */
public interface BeanFactoryAware {

    void setBeanFactory(BeanFactory beanFactory) throws Exception;

}
