package com.cyn.cloud.service.impl;

import com.cyn.cloud.bean.User;
import com.cyn.cloud.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述
 *
 * @ProjectName: springcloud
 * @Package: com.cyn.cloud.service.impl
 * @Date 2020/3/12 20:19
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: 模拟用户服务接口实现
 **/
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void create(User user) {

    }

    @Override
    public User getUser(Long id) {
        return new User(1,"test","test");
    }

    @Override
    public List<User> getUserByIds(List<Long> ids) {
        List<User> list = new ArrayList<>();
        list.add(new User(1,"test","test"));
        return list;
    }

    @Override
    public User getByUsername(String username) {
        return new User(1,"test","test");
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Long id) {

    }
}
