package com.cyn.cloud.controller;

import com.cyn.cloud.bean.User;
import com.cyn.cloud.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文件描述
 *
 * @ProjectName: springcloud
 * @Package: com.cyn.cloud.controller
 * @Date 2020/3/12 20:14
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: 模拟用户服务
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public String create(@RequestBody User user) {
        userService.create(user);
        return "操作成功";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id) throws InterruptedException {
        User user = userService.getUser(id);
        Thread.sleep(3000);
        LOGGER.info("根据id获取用户信息，用户名称为：{}", user.getUsername());
        return "根据id获取用户信息，用户名称为：{}";
    }

    @GetMapping("/getUserByIds")
    public String getUserByIds(@RequestParam List<Long> ids) {
        List<User> userList = userService.getUserByIds(ids);
        LOGGER.info("根据ids获取用户信息，用户列表为：{}", userList);
        return "根据ids获取用户信息，用户列表为：{}" + userList.toString();
    }

    @GetMapping("/getByUsername")
    public String getByUsername(@RequestParam String username) {
        User user = userService.getByUsername(username);
        return "根据username获取用户信息，用户为：{}" + user.toString();
    }

    @PostMapping("/update")
    public String update(@RequestBody User user) {
        userService.update(user);
        return "update操作成功";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "delete操作成功";
    }
}
