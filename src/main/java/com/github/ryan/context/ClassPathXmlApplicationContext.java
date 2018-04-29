package com.github.ryan.context;

import com.github.ryan.beans.BeanDefinition;
import com.github.ryan.beans.factory.AbstractBeanFactory;
import com.github.ryan.beans.factory.AutowireCapableBeanFactory;
import com.github.ryan.beans.io.ResourceLoader;
import com.github.ryan.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: ClassPathXmlApplicationContext
 * @date May 12,2017
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(configLocation, new AutowireCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String configLocation, AbstractBeanFactory beanFactory)
            throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

//    @Override
//    public void refresh() throws Exception {
//        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
//        beanDefinitionReader.loadBeanDefinitions(configLocation);
//        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry :
//                beanDefinitionReader.getRegistry().entrySet()) {
//            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
//        }
//    }

    // 该方法需要把 BeanDefinitionReader 中 registry 保存的 beanDefinition 循环复制到 BeanFactory 的 beanDefinitionMap

    /**
     * 参考Spring可以优化：通过 BeanDefinitionRegistry 接口暴露BeanDefinition的注册，获取等方法，
     * BeanDefinitionReader 的 getRegistry 方法会返回实现了BeanDefinitionRegistry接口的BeanFactory实例，
     * 然后通过 BeanDefinitionRegistry 暴露出来的接口，可以直接把BeanDefinition定义保存到BeanFactory，不需要
     * 在BeanDefinitionReader中也保存一份
     *
     * @param beanFactory
     * @throws Exception
     */
    @Override
    protected void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        beanDefinitionReader.loadBeanDefinitions(configLocation);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry :
                beanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }
}
