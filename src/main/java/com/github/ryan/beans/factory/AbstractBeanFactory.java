package com.github.ryan.beans.factory;

import com.github.ryan.beans.BeanDefinition;
import com.github.ryan.beans.BeanPostProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: AbstractBeanFactory
 * @date May 09,2017
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private final List<String> beanDefinitionNames = new ArrayList<>();

    private List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    // 使用模版方法模式：getBean方法控制算法流程，保留扩展点给相应的子类实现
    // 主要包含实例化(创建实例，注入属性包括依赖注入，处理BeanFactoryAware)和初始化操作
    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No bean named " + name + " is defined.");
        }
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = doCreateBean(beanDefinition);
            bean = initializeBean(bean, name);
            // 在 doCreateBean 中已经赋值过一次了，这里需要再赋值一次
            // 因此 initializeBean 方法返回之后，该bean可能已经变了(比如返回代理实现类)
            beanDefinition.setBean(bean);
        }
        return bean;
    }

    protected Object initializeBean(Object bean, String beanName) throws Exception {
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            bean = beanPostProcessor.postProcessBeforeInitialization(bean, beanName);
        }

        // TODO: call initialize method

        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            bean = beanPostProcessor.postProcessAfterInitialization(bean, beanName);
        }
        return bean;
    }

    // @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        //Object bean = doCreateBean(beanDefinition);
        //beanDefinition.setBean(bean);
        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
    }

    // 以单例方式初始化所有的bean，目前只支持单例模式
    public void preInstantiateSingletons() throws Exception {
        for (String beanName : this.beanDefinitionNames) {
            getBean(beanName);
        }
    }

    /**
     * 初始化Bean
     * 总是先创建bean实例，然后把bean实例通过beanDefinition暴露给IoC容器
     * 然后再注入属性（依赖注入时需要递归调用getBean），所以不会出现 A-B-A 这种循环依赖带来的问题
     * （不严谨，如果在构造方法中注入bean，反射调用时还会出现循环依赖）
     *
     * @param beanDefinition
     * @return
     */
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception  {
        Object bean = createBeanInstance(beanDefinition);
        beanDefinition.setBean(bean);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    public Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    // 钩子方法，由子类提供具体的属性注入实现
    protected abstract void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception;

    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        beanPostProcessors.add(beanPostProcessor);
    }

    public List<?> getBeansForType(Class type) throws Exception {
        List<Object> beans = new ArrayList<>();
        for (String beanDefinitionName : beanDefinitionNames) {
            if (type.isAssignableFrom(beanDefinitionMap.get(beanDefinitionName).getBeanClass())) {
                Object bean = getBean(beanDefinitionName);
                beans.add(bean);
            }
        }
        return beans;
    }
}
