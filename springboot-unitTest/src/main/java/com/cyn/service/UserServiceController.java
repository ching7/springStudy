package com.cyn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-09-07
 */
@RestController
public class UserServiceController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserServiceImpl userService;
    @Autowired
    @Qualifier("UserServiceImpl2")
    private UserServiceImpl2 userService2;

    //    @Autowired
//    private UserService userService3;
    @RequestMapping("/addUser")
    public void addUser() {
        userService.addUser();
    }

    @RequestMapping("/addUser2")
    public void addUser2() {
        userService2.addUser();
    }

//    @Test
//    public void addUser3() {
//        userService3.addUser();
//    }
}
