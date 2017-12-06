package com.github.ryan;

import lombok.Setter;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: AopTestService
 * @date December 06,2017
 */
public class AopTestService {

    //@Setter
    private static String text;

    public static void say() {
        System.out.println(text);
    }
}
