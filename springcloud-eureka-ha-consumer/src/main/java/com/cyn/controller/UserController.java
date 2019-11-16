package com.cyn.controller;

import com.cyn.pojo.User;
import com.cyn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyn
 * @version 1.0
 * @date 2019/10/27 19:57
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/userConsumer")
    public List<User> getUsers(){

        return userService.getUser();
    }
}
