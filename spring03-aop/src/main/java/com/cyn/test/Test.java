package com.cyn.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
       /* Demo demo =  ac.getBean("demoTest",Demo.class);
        demo.demo1();
        demo.demo2();
        demo.demo3();
        demo.demo4("传递的参数123123123");
        demo.demo5("传递的参数112222222222223");*/
        Demo1 demo1 =  ac.getBean("demoTest1",Demo1.class);
        try {
            demo1.Demo11();
        }catch (Exception e){
            //e.printStackTrace();
        }

    }
}
