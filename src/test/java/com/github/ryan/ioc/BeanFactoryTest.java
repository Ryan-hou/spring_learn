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
    public void test() {
        // 1:初始化BeanFactory
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        // 2:注入Bean
//        BeanDefinition beanDefinition = new BeanDefinition(new HelloWorldService());
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.github.ryan.ioc.HelloWorldService");
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        // 3:获取Bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}