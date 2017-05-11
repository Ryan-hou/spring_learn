package com.github.ryan.ioc;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: BeanReference
 * @date May 10,2017
 */
public class BeanReference {

    @Getter @Setter
    private String name;

    @Getter @Setter
    private Object bean;

    public BeanReference(String name) {
        this.name = name;
    }
}
