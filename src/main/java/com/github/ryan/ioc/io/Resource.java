package com.github.ryan.ioc.io;

import java.io.InputStream;

/**
 * @author ryan.houyl@gmail.com
 * @description: Resource是spring内部定位资源的接口。
 * @className: Resource
 * @date May 09,2017
 */
public interface Resource {

    InputStream getInputStream() throws Exception;
}
