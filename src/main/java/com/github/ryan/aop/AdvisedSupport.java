package com.github.ryan.aop;

import lombok.Getter;
import lombok.Setter;
import org.aopalliance.intercept.MethodInterceptor;

/**
 * Base class for AOP proxy configuration managers.
 * These are not themselves AOP proxies, but subclasses
 * of this class are normally factories from which AOP
 * proxy instances are obtained directly.
 *
 * @author ryan.houyl@gmail.com
 * @description: 代理相关的元数据
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
