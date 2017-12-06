package com.github.ryan.aop;

import com.github.ryan.AopTestService;
import com.github.ryan.HelloWorldService;
import com.github.ryan.context.ApplicationContext;
import com.github.ryan.context.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: Cglib2AopProxyTest
 * @date December 05,2017
 */
public class Cglib2AopProxyTest {

    @Test
    public void testInterceptor() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("simpleioc.xml");
        //HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        //helloWorldService.helloWorld();
        AopTestService aopTestService = (AopTestService) applicationContext.getBean("aopTestService");
        aopTestService.say();
    }
}
