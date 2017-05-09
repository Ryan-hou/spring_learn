package com.github.ryan.ioc;

import com.github.ryan.ioc.factory.AutowireCapableBeanFactory;
import com.github.ryan.ioc.factory.BeanFactory;
import org.junit.Test;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: BeanFactoryTest
 * @date May 08,2017
 */
public class BeanFactoryTest {

    @Test
    public void test() throws Exception {
        // 1:初始化BeanFactory
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        // 2:bean 的定义
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.github.ryan.ioc.HelloWorldService");

        // 3:设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("text", "Hello World!"));
        beanDefinition.setPropertyValues(propertyValues);

        // 4:生成bean
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        // 5:获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}