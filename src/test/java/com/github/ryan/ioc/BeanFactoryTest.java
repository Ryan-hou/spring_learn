package com.github.ryan.ioc;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: BeanFactoryTest
 * @date May 08,2017
 */
public class BeanFactoryTest {

    @Test
    public void test() {
        // 1:初始化BeanFactory
        BeanFactory beanFactory = new BeanFactory();

        // 2:注入Bean
        BeanDefinition beanDefinition = new BeanDefinition(new HelloWorldService());
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        // 3:获取Bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}