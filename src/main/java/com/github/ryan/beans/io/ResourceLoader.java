package com.github.ryan.beans.io;

import java.net.URL;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * 这里在设计上有一定的问题，ResourceLoader 直接返回了一个 UrlResource，
 * 更好的方法是声明一个 ResourceLoader 接口，再实现一个 UrlResourceLoader 类用于加载 UrlResource
 * @className: ResourceLoader
 * @date May 09,2017
 */
public class ResourceLoader {

    public Resource getResource(String location) {
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
