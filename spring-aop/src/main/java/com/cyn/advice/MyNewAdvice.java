package com.cyn.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author chenyn
 * @version 1.0
 * @date 2019/8/28 23:43
 */
@Component
@Aspect
public class MyNewAdvice {
    @Before("com.cyn.test.Demo123.demo1()")
    public void before(){
        System.out.println("注解前置--");
    }
}
