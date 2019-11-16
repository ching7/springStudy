package com.cyn.controller;

import com.cyn.pojo.User;
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
    @RequestMapping("/user")
    public List<User> getUsers(){
        List<User> listUser = new ArrayList<>();
        listUser.add(new User("装三",12,"男"));
        listUser.add(new User("wangwu",14,"男"));
        listUser.add(new User("zhuangwu",16,"男"));
        return listUser;
    }
}
