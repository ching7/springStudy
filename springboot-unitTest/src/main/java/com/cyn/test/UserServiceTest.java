package com.cyn.test;

import com.cyn.App;
import com.cyn.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 文件描述
 *
 * @ProjectName: springboot-unitTest
 * @Package: com.cyn.test
 * @Description:
 *
 * springboot 测试类
 *
 * @RunWith(value = SpringJUnit4ClassRunner.class): 启动器
 * SpringJUnit4ClassRunner 让junit和spring环境整合
 *
 * @SpringBootTest(classes = {App.class})
 * 1.当前类为springBoot的测试类
 * 2.加载springboot启动类，启动springboot
 *
 * junit整合spring,@ContextConfiguration("classpath:application.xml")
 *
 **/
@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
public class UserServiceTest {
    @Autowired
    private UserServiceImpl userService;

    @Test
    public void addUser(){
        userService.addUser();
    }
}
