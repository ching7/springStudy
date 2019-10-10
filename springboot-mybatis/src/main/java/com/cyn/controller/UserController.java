package com.cyn.controller;

import com.cyn.bean.User;
import com.cyn.service.UserService;
import com.cyn.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: springboot-mybatis
 * @Package: com.cyn.controller
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/10/10 14:50
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/10/10 14:50
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 页面跳转
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping("/addUser")
    public String addUser(User user){
        this.userService.addUser(user);
        return "ok";
    }

    @RequestMapping("/findUserAll")
    public String findUserAll(Model model){
        List<User> list = this.userService.findUserAll();
        model.addAttribute("list",list);
        return "showUser";
    }
}
