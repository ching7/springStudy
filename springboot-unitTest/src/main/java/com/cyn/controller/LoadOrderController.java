package com.cyn.controller;

import com.cyn.bean.UserBean;
import com.cyn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: 代码执行顺序
 * 静态块/静态变量>构造块>构造方法。
 * <p>
 *
 * @Author: ynchen9
 * @CreateTime: 2021-06-08
 */
@RestController
public class LoadOrderController {
    public static String text = "静态变量";
    @Autowired
    UserService userService;

    LoadOrderController() {
        System.out.println("UserController 构造方法");
    }

    {
        System.out.println("UserController 构造块");

    }

    static {
        System.out.println("UserController " + text);
        System.out.println("UserController 静态块");
    }

    @GetMapping("/unit/getUser")
    public UserBean getUser() {
        return userService.getUser();
    }
}
