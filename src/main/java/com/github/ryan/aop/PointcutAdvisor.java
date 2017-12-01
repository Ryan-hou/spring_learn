package com.github.ryan.aop;

/**
 * @author ryan.houyl@gmail.com
 * @description:
 * @className: PointcutAdvisor
 * @date December 01,2017
 */
public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();

}
