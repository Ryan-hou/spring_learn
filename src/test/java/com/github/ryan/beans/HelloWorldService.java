package com.github.ryan.beans;

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

    @Setter
    private OutputService outputService;

    public void helloWorld() {
        // System.out.println(text);
        outputService.output(text);
    }
}
