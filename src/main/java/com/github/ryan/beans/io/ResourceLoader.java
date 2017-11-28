package com.github.ryan.beans.io;

import java.net.URL;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: ResourceLoader
 * @date May 09,2017
 */
public class ResourceLoader {

    public Resource getResource(String location) {
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
