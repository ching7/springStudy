package com.cyn.service.controller;

import com.cyn.api.entity.MyUser;
import com.cyn.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    @Resource
    private  UserService userService;

    @GetMapping("/qs/getUserInfo")
    public MyUser getUserInfo() {
       return userService.getUserInfo();
    }

    @GetMapping("/qs/getUserInfoStaticTest")
    public MyUser getUserInfoStaticTest() {
        return  userService.getUserInfo();
    }

}
