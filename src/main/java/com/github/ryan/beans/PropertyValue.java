package com.github.ryan.beans;

import lombok.Getter;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * 用于bean的属性注入
 * 实际上是k-v键值对，通过 PropertyValue 类封装，赋予明确的语义
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
