package com.cyn.advice;

import org.springframework.aop.ThrowsAdvice;

/**
 * @author chenyn
 * @version 1.0
 * @date 2019/8/26 23:22
 */
public class MyThrowAdvice implements ThrowsAdvice{
    public void myException(Exception e){
        System.out.println("执行异常通知" + e.getMessage());
    }
}
