package com.github.ryan.ioc;

import lombok.Setter;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: HelloWorldService
 * @date May 08,2017
 */
public class HelloWorldService {

    @Setter
    private String text;

    public void helloWorld() {
        System.out.println(text);
    }
}
