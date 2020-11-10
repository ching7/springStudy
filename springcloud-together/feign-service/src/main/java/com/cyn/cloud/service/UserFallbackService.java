package com.cyn.cloud.service;

import com.cyn.cloud.bean.User;
import org.springframework.stereotype.Component;

/**
 * 文件描述
 *
 * @ProjectName: springcloud
 * @Package: com.cyn.cloud.service
 * @Date 2020/3/17 14:53
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
@Component
public class UserFallbackService implements UserService {
    @Override
    public String create(User user) {
        User defaultUser = new User(1, "defaultCreateUser", "123456");
        return defaultUser.toString();
    }

    @Override
    public String getUser(Long id) {
        User defaultUser = new User(1, "defaultGetUser", "123456");
        return defaultUser.toString();
    }

    @Override
    public String getByUsername(String username) {
        User defaultUser = new User(1, "defaultGetByUsername", "123456");
        return defaultUser.toString();
    }

    @Override
    public String update(User user) {
        User defaultUser = new User(1, "defaultUpdate", "123456");
        return defaultUser.toString();
    }

    @Override
    public String delete(Long id) {
        User defaultUser = new User(1, "defaultDelete", "123456");
        return defaultUser.toString();
    }
}
