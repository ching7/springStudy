package com.cyn.controller;

import com.cyn.bean.UserBean;
import com.cyn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @Description: 注入bean的时间点
 * 构造器(Constructor) >> @Resource(@Autowired) >> @PostConstruct >> init()
 * @Author: ynchen9
 * @CreateTime: 2021-06-08
 */
@RestController
public class StaticInjectBeanController {
    /**
     * 依赖注入的3种方式
     * 1 基于构造函数的依赖注入
     * 2 基于setter的依赖注入
     * 3 基于字段的依赖注入
     */

/*
    //基于字段的依赖注入
    @Autowired
    UserService userService;
    */


/*
     //基于构造函数的依赖注入
    private final UserService userService;
    @Autowired
    public StaticInjectBeanController(UserService userService) {
        this.userService = userService;
    }
    */


    //基于Setter的依赖注入
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    // 静态方法可以用的bean
    private static UserService userServiceTemplate;

    @PostConstruct
    private void init() {
        userServiceTemplate = userService;
    }

    @GetMapping("/unit/getUserStaticT1")
    public UserBean getUserStaticT1() {
        return userService.getUser();
    }

    @GetMapping("/unit/getUserStaticT2")
    public UserBean getUserStaticT2() {
        return getUserStaticM();
    }

    public static UserBean getUserStaticM() {
        return userServiceTemplate.getUser();
    }
}
