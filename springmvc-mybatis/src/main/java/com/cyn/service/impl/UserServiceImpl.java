package com.cyn.service.impl;

import com.cyn.mapper.UserMapper;
import com.cyn.pojo.User;
import com.cyn.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> showAllUser() {
        return userMapper.selAll();
    }
}
