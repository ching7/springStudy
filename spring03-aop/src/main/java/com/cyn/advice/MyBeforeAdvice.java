package com.cyn.advice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MyBeforeAdvice implements MethodBeforeAdvice {


    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        /*System.out.println("切点方法对象:"+method+"方法名："+method.getName());
        if (objects != null && objects.length>0) {
            System.out.println("切点方法入参："+ objects[0]);
        }else{
            System.out.println("切点方法无入参");
        }
        System.out.println("切点方法参数:"+objects);
        System.out.println("对象:"+o);*/

        System.out.println(":MyBeforeAdvice");
    }
}
