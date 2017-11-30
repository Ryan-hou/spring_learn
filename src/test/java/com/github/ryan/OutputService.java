package com.github.ryan;

import lombok.Setter;
import org.junit.Assert;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: OutputService
 * @date May 10,2017
 */
public class OutputService {

    @Setter
    private HelloWorldService helloWorldService;

    public void output(String text) {
        Assert.assertNotNull(helloWorldService);
        System.out.println(text);
    }
}
