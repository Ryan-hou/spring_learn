package com.github.ryan.context;

import com.github.ryan.beans.factory.AbstractBeanFactory;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: AbstractApplicationContext
 * @date May 12,2017
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    protected void refresh() throws Exception {

    }

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }
}
