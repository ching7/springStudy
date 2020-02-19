package com.cyn.advice;

import org.springframework.aop.ThrowsAdvice;

import java.rmi.RemoteException;

/**
 * @author chenyn
 * @version 1.0
 * @date 2019/8/27 22:55
 */
public class MyThrowAdviceSchemaBase implements ThrowsAdvice {
    public void afterThrowing(Exception ex) throws Throwable{
        System.out.println("执行异常通知 afterThrowing --schema base 实现" + ex);
    }
}
