package com.cyn.service.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-08-09
 */
@RestController
@RequestMapping("/event")
public class UserEventController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(String username){
        userService.register(username);
        return "恭喜注册成功!";
    }
}
