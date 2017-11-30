package com.github.ryan.context;

import com.github.ryan.HelloWorldService;
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