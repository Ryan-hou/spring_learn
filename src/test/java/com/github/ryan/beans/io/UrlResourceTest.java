package com.github.ryan.beans.io;

import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: UrlResourceTest
 * @date May 09,2017
 */
public class UrlResourceTest {

    @Test
    public void test() throws Exception {
        ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource = resourceLoader.getResource("simpleioc.xml");
        InputStream inputStream = resource.getInputStream();
        Assert.assertNotNull(inputStream);
    }

}