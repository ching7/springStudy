package com.cyn.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        String [] names =  ac.getBeanDefinitionNames();
        System.out.println(Arrays.toString(names));
       /* Demo demo =  ac.getBean("demoTest",Demo.class);
        demo.demo1();
        demo.demo2();
        demo.demo3();
        demo.demo4("传递的参数123123123");
        demo.demo5("传递的参数112222222222223");*/

        // 异常通知的aspectJ实现
        Demo1 demo1 =  ac.getBean("demoTest1",Demo1.class);
        /*try {
            demo1.Demo11();
        }catch (Exception e){
            //e.printStackTrace();
        }

        try {
            demo1.Demo12();

        }catch (Exception e){

        }
        demo1.Demo13();*/
        // demo1.Demo14("张三",12);
        Demo123 demo123 =  ac.getBean("demo123",Demo123.class);
        demo123.demo1();
    }
}
