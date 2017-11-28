package com.github.ryan.beans.context;

import com.github.ryan.beans.HelloWorldService;
import com.github.ryan.context.ApplicationContext;
import com.github.ryan.context.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: ClassPathXmlApplicationContextTest
 * @date May 12,2017
 */
public class ClassPathXmlApplicationContextTest {

    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("simpleioc.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}