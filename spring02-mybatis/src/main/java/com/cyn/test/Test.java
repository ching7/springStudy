package com.cyn.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.ibatis.scripting.LanguageDriver;

public class Test {
    public static void main(String[] args) {
        //ClassPathXmlApplicationContext 默认去resource文件夹根目录查找spring配置文件applicationContext.xml
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        String[] names =  applicationContext.getBeanDefinitionNames();
        for (String s: names
             ) {
            System.out.println(s);
        }
    }
}
