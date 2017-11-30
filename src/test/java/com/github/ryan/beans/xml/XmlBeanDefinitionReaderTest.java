package com.github.ryan.beans.xml;

import com.github.ryan.BeanDefinition;import com.github.ryan.BeanDefinition;
import com.github.ryan.beans.io.ResourceLoader;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: XmlBeanDefinitionReaderTest
 * @date May 09,2017
 */
public class XmlBeanDefinitionReaderTest {

    @Test
    public void test() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("simpleioc.xml");
        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
        Assert.assertTrue(registry.size() > 0);
    }

}