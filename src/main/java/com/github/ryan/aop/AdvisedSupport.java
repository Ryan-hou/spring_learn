package com.github.ryan.aop;

import lombok.Getter;
import lombok.Setter;
import org.aopalliance.intercept.MethodInterceptor;

/**
 * @author ryan.houyl@gmail.com
 * @description: 代理相关的原数据
 * @className: AdvisedSupport
 * @date November 30,2017
 */
public class AdvisedSupport {

    @Getter @Setter
    private TargetSource targetSource;
    // Advice: interceptor type
    @Getter @Setter
    private MethodInterceptor methodInterceptor;

    @Getter @Setter
    private MethodMatcher methodMatcher;
}
