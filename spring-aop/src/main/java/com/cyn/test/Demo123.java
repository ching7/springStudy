package com.cyn.test;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class Demo123 {

    @Pointcut("execution(* com.cyn.test.Demo123.demo1())")
    public void demo1(){
        System.out.println("demo1");
    }
    public void demo2(){
        System.out.println("demo2");
    }
    public void demo3(){
        System.out.println("demo3");
    }
    public void demo4(String str){
        System.out.println("demo4");
    }
    public String demo5(String str){
        System.out.println("demo5");
        return str;
    }

}
