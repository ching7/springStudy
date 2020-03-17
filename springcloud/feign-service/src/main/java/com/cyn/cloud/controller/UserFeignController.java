package com.cyn.cloud.controller;

import com.cyn.cloud.bean.User;
import com.cyn.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 文件描述
 *
 * @ProjectName: springcloud
 * @Package: com.cyn.cloud.controller
 * @Date 2020/3/17 11:18
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
@RestController
@RequestMapping("/user")
public class UserFeignController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id) {
        String res = userService.getUser(id);
        return res;
    }

    @GetMapping("/getByUsername")
    public String getByUsername(@RequestParam String username) {
        return userService.getByUsername(username);
    }

    @PostMapping("/create")
    public String create(@RequestBody User user) {
        return userService.create(user);
    }

    @PostMapping("/update")
    public String update(@RequestBody User user) {
        return userService.update(user);
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return userService.delete(id);
    }
}