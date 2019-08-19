package com.cyn.advice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MyBeforeAdvice implements MethodBeforeAdvice {


    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(":MyBeforeAdvice");
    }
}
