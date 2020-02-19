package com.cyn.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class MyAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("切点方法对象:"+method+"方法名："+method.getName());
        if (o != null) {
            System.out.println("切点方法出参："+ o);
        }else{
            System.out.println("切点方法无出参");
        }
        System.out.println("切点方法参数:"+objects);
        System.out.println("切点方法所在类对象:"+o1);

        System.out.println(":MyAfterAdvice");
    }
}
