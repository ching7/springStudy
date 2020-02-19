package com.cyn.advice;

/**
 * @author chenyn
 * @version 1.0
 * @date 2019/8/27 23:35
 */
public class MyAfterAdviceAspectJ  {
    public void after(){
        System.out.println("后置通知--aspectJ写法");
    }
    public void before(String name1,int age1){
        System.out.println("前置通知--aspectJ写法"+name1+age1);
    }
}
