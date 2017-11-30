package com.github.ryan;

import lombok.Setter;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: HelloWorldServiceImpl
 * @date November 30,2017
 */
public class HelloWorldServiceImpl implements HelloWorldService {

    @Setter
    private String text;
    @Setter
    private OutputService outputService;

    @Override
    public void helloWorld() {
        outputService.output(text);
    }
}
