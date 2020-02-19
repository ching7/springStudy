package com.cyn.test;

import com.cyn.pojo.User;
import com.cyn.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        //ClassPathXmlApplicationContext 默认去resource文件夹根目录查找spring配置文件applicationContext.xml
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        String[] names =  applicationContext.getBeanDefinitionNames();
        for (String s: names
             ) {
            System.out.println(s);
        }

        UserServiceImpl bean = applicationContext.getBean("userService", UserServiceImpl.class);
        List<User> list = bean.showAllUser();
        for (User u : list
             ) {
            System.out.println(u);
        }
    }
}
