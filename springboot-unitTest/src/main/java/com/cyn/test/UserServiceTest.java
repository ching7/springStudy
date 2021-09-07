package com.cyn.test;

import com.cyn.App;
import com.cyn.service.UserService;
import com.cyn.service.UserServiceImpl;
import com.cyn.service.UserServiceImpl2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 文件描述
 *
 * @ProjectName: springboot-unitTest
 * @Package: com.cyn.test
 * @Description: springboot 测试类
 * @RunWith(value = SpringJUnit4ClassRunner.class): 启动器
 * SpringJUnit4ClassRunner 让junit和spring环境整合
 * @SpringBootTest(classes = {App.class})
 * 1.当前类为springBoot的测试类
 * 2.加载springboot启动类，启动springboot
 * <p>
 * junit整合spring,@ContextConfiguration("classpath:application.properties.xml")
 **/
@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
public class UserServiceTest {
    //@Autowired
    //@Qualifier("UserServiceImpl")
    @Resource(name = "UserServiceImpl")
    private UserServiceImpl userService;
    //@Autowired
    //@Qualifier("UserServiceImpl2")
    @Resource(name = "UserServiceImpl2")
    private UserServiceImpl2 userService2;

    //    @Autowired
//    private UserService userService3;
    @Test
    public void addUser() {
        userService.addUser();
    }

    @Test
    public void addUser2() {
        userService2.addUser();
    }

//    @Test
//    public void addUser3() {
//        userService3.addUser();
//    }
}
