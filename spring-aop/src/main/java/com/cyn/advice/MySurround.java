package com.cyn.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author chenyn
 * @version 1.0
 * @date 2019/8/27 23:20
 */
public class MySurround implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("环绕-前置");
        //放行，调用切点方法
        Object result = methodInvocation.proceed();
        System.out.println("环绕-后置 出参" +result);
        return null;
    }
}
