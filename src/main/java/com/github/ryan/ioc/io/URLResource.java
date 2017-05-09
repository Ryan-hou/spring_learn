package com.github.ryan.ioc.io;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: UrlResource
 * @date May 09,2017
 */
public class UrlResource implements Resource {

    private final URL url;

    public UrlResource(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws Exception {
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        return urlConnection.getInputStream();
    }
}
