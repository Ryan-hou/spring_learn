package com.github.ryan.ioc;

import com.github.ryan.ioc.factory.AbstractBeanFactory;
import com.github.ryan.ioc.factory.AutowireCapableBeanFactory;
import com.github.ryan.ioc.factory.BeanFactory;
import com.github.ryan.ioc.io.ResourceLoader;
import com.github.ryan.ioc.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: BeanFactoryTest
 * @date May 08,2017
 */
public class BeanFactoryTest {

    @Test
    public void testLazy() throws Exception {
        // 1:读取配置
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        beanDefinitionReader.loadBeanDefinitions("simpleioc.xml");

        // 2:初始化BeanFactory并注册bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : beanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 3:获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }


    @Test
    public void testPreInstantiate() throws Exception {
        // 1:读取配置
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        beanDefinitionReader.loadBeanDefinitions("simpleioc.xml");

        // 2:初始化BeanFactory并注册bean
        AbstractBeanFactory factory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : beanDefinitionReader.getRegistry().entrySet()) {
            factory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 3:初始化bean
        factory.preInstantiateSingletons();

        // 4:获取bean
        HelloWorldService helloWorldService = (HelloWorldService) factory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }


    @Test
    public void test() throws Exception {

        // 1:读取配置
//        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
//        xmlBeanDefinitionReader.loadBeanDefinitions("simpleioc.xml");
//
//        // 2:初始化 BeanFactory 并注册bean
//        BeanFactory factory = new AutowireCapableBeanFactory();
//        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry :
//                xmlBeanDefinitionReader.getRegistry().entrySet()) {
//            factory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
//        }
//
//        // 3:获取bean
//        HelloWorldService helloWorldServie = (HelloWorldService) factory.getBean("helloWorldService");
//        helloWorldServie.helloWorld();

// **************************************************************************

//        // 1:初始化BeanFactory
//        BeanFactory beanFactory = new AutowireCapableBeanFactory();
//
//        // 2:bean 的定义
//        BeanDefinition beanDefinition = new BeanDefinition();
//        beanDefinition.setBeanClassName("com.github.ryan.ioc.HelloWorldService");
//
//        // 3:设置属性
//        PropertyValues propertyValues = new PropertyValues();
//        propertyValues.addPropertyValue(new PropertyValue("text", "Hello World!"));
//        beanDefinition.setPropertyValues(propertyValues);
//
//        // 4:生成bean
//        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);
//
//        // 5:获取bean
//        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
//        helloWorldService.helloWorld();
    }
}