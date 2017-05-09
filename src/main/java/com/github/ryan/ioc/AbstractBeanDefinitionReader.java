package com.github.ryan.ioc;

import com.github.ryan.ioc.io.ResourceLoader;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: AbstractBeanDefinitionReader
 * @date May 09,2017
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    @Getter
    private ResourceLoader resourceLoader;

    @Getter
    private Map<String, BeanDefinition> registry;

    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        this.registry = new HashMap<>();
    }
}
