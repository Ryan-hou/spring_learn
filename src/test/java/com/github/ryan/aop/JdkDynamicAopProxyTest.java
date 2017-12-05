package com.github.ryan.aop;

import com.github.ryan.HelloWorldService;
import com.github.ryan.context.ApplicationContext;
import com.github.ryan.context.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: JdkDynamicAopProxyTest
 * @date November 30,2017
 */
public class JdkDynamicAopProxyTest {


    @Test
    public void testInterceptor() throws Exception {
        // ---------- helloWorldService without AOP
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("simpleioc.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        // helloWorldService.helloWorld();

        // ---------- helloWorldService with AOP
        // 1.设置被代理对象(Joinpoint)
        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(helloWorldService, helloWorldService.getClass(), helloWorldService.getClass().getInterfaces());
        //TargetSource targetSource = new TargetSource(new Class[] { HelloWorldService.class }, helloWorldService);
        advisedSupport.setTargetSource(targetSource);

        // 2.设置拦截器(Advice)
        TimerInterceptor timerInterceptor = new TimerInterceptor();
        advisedSupport.setMethodInterceptor(timerInterceptor);

        // 3.创建代理(Proxy)
        JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
        HelloWorldService helloWorldServiceProxy = (HelloWorldService) jdkDynamicAopProxy.getProxy();

        // 4.基于AOP的调用
        helloWorldServiceProxy.helloWorld();

    }
}
