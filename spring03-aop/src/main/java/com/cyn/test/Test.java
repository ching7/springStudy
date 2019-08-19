package com.cyn.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Demo demo =  ac.getBean("demoTest",Demo.class);
        demo.demo1();
        demo.demo2();
        demo.demo3();
    }
}
