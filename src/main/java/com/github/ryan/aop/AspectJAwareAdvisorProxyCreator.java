package com.github.ryan.aop;

import com.github.ryan.beans.BeanFactoryAware;
import com.github.ryan.beans.BeanPostProcessor;
import com.github.ryan.beans.factory.AbstractBeanFactory;
import com.github.ryan.beans.factory.BeanFactory;
import org.aopalliance.intercept.MethodInterceptor;

import java.util.List;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * 解决AOP的植入问题：
 * 1）在 IoC 容器的何处植入 AOP？
 * BeanPostProcessor ：在 postProcessorAfterInitialization 方法中，使用动态代理的方式，
 * 返回一个对象的代理对象。解决了 在 IoC 容器的何处植入 AOP 的问题。
 * 2）为哪些对象提供 AOP 的植入？
 * BeanFactoryAware ：这个接口提供了对 BeanFactory 的感知，这样，尽管它是容器中的一个 Bean，
 * 却可以获取容器的引用，进而获取容器中所有的切点对象，决定对哪些对象的哪些方法进行代理。
 * 解决了 为哪些对象提供 AOP 的植入 的问题。
 *
 * @className: AspectJAwareAdvisorProxyCreator
 * @date December 05,2017
 */
public class AspectJAwareAdvisorProxyCreator implements BeanPostProcessor, BeanFactoryAware {

    private AbstractBeanFactory beanFactory;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        if (bean instanceof AspectJExpressionPointcutAdvisor) {
            return bean;
        }
        if (bean instanceof MethodInterceptor) {
            return bean;
        }

        // 加载 BeanFactory 中所有的 PointcutAdvisor（这也保证了 PointcutAdvisor 的实例化顺序优于普通 Bean
        // 然后依次使用 PointcutAdvisor 内置的 ClassFilter，判断当前对象是不是要拦截的类。
        // 如果是，则生成一个 TargetSource（要拦截的对象和其类型），并取出 AutoProxyCreator 的 MethodMatcher（对哪些方法进行拦截）、
        // Advice（拦截的具体操作），再交给 AopProxy 去生成代理对象。
        List<AspectJExpressionPointcutAdvisor> advisors = (List<AspectJExpressionPointcutAdvisor>) beanFactory
                .getBeansForType(AspectJExpressionPointcutAdvisor.class);
        for (AspectJExpressionPointcutAdvisor advisor : advisors) {
            if (advisor.getPointcut().getClassFilter().matches(bean.getClass())) {
                // advisedSupport 需要提供代理相关的元数据：targetSource／methodInterceptor／methodMatcher
                ProxyFactory advisedSupport = new ProxyFactory();
                //AdvisedSupport advisedSupport = new AdvisedSupport();
                advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
                advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());

                TargetSource targetSource = new TargetSource(bean, bean.getClass(), bean.getClass().getInterfaces());
                advisedSupport.setTargetSource(targetSource);

                //return new JdkDynamicAopProxy(advisedSupport).getProxy();
                return advisedSupport.getProxy();
            }
        }
        return bean;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws Exception {
       this.beanFactory = (AbstractBeanFactory) beanFactory;
    }
}
