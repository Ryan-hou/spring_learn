package com.github.ryan.beans;

import com.github.ryan.beans.factory.BeanFactory;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * Interface to be implemented by beans that wish to be aware of
 * their owning BeanFactory.
 *
 * 容器感知的bean，可以获取容器的引用
 * @className: BeanFactoryAware
 * @date December 04,2017
 */
public interface BeanFactoryAware {

    /**
     * Callback that supplies the owning factory to a bean instance.
     *
     * @param beanFactory owning BeanFactory never null
     * The bean can immediately call methods on the factory.
     */
    void setBeanFactory(BeanFactory beanFactory) throws Exception;

}
