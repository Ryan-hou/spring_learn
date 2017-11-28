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

    @Override
    public void refresh() throws Exception {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        beanDefinitionReader.loadBeanDefinitions(configLocation);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry :
                beanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }
}
