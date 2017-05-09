package com.github.ryan.ioc;

import lombok.Getter;

/**
 * @author ryan.houyl@gmail.com
 * @description: 用于bean的属性注入
 * @className: PropertyValue
 * @date May 09,2017
 */
public class PropertyValue {

    @Getter
    private final String name;

    @Getter
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

}
