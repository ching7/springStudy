package com.cyn.service.controller;

import com.cyn.api.entity.MyUser;
import com.cyn.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件描述
 *
 * @ProjectName: springboot-quick-start
 * @Package: PACKAGE_NAME
 * @Date 2020/7/10 10:59
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
@RestController
public class UserController {
    @Autowired
    private static UserService userService;

    @RequestMapping("/qs/getUserInfo")
    public MyUser getUserInfo() {
       return userService.getUserInfo();
    }

    @RequestMapping("/qs/getUserInfoStaticTest")
    public MyUser getUserInfoStaticTest() {
        return getTestBean();
    }

}
