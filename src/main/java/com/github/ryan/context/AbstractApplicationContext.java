package com.github.ryan.context;

import com.github.ryan.beans.BeanPostProcessor;
import com.github.ryan.beans.factory.AbstractBeanFactory;

import java.util.List;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: AbstractApplicationContext
 * @date May 12,2017
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    // 代理模式，beanFactory 用来进行方法转发
    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    // 模版方法模式
    // 实例化顺序：实现BeanPostProcessor 接口的bean -> PointcutAdvisor(在BeanPostProcessor接口的方法中实例化) -> 普通的bean
    protected void refresh() throws Exception {
        loadBeanDefinitions(beanFactory);
        registerBeanPostProcessors(beanFactory);
        onRefresh();
    }

    protected abstract void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception;

    protected void registerBeanPostProcessors(AbstractBeanFactory beanFactory) throws Exception {
        // 实现了 BeanPostProcessor 接口的bean，在实例化所有的 Bean 前，最先被实例化，
        // 这样就保证了普通的bean可以被正常的初始化
        List<Object> beanPostProcessors = (List<Object>) beanFactory.getBeansForType(BeanPostProcessor.class);
        for (Object beanPostProcessor : beanPostProcessors) {
            beanFactory.addBeanPostProcessor((BeanPostProcessor) beanPostProcessor);
        }
    }

    protected void onRefresh() throws Exception {
        beanFactory.preInstantiateSingletons();
    }

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }
}
