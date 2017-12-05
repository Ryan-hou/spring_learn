package com.github.ryan;

import lombok.Setter;
import org.junit.Assert;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: OutputServiceImpl
 * @date December 04,2017
 */
public class OutputServiceImpl implements OutputService {

    //@Setter
    //private HelloWorldService helloWorldService;

    @Override
    public void output(String text) {
        //Assert.assertNotNull(helloWorldService);
        System.out.println(text);
    }
}
