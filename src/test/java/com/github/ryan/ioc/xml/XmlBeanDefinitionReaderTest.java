package com.github.ryan.ioc.xml;

import com.github.ryan.ioc.BeanDefinition;
import com.github.ryan.ioc.io.ResourceLoader;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author yanlin.hou@ucarinc.com
 * @description:
 * @className: ${name}
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