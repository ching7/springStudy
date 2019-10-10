package com.cyn.service.impl;

import com.cyn.bean.User;
import com.cyn.mapper.UserMapper;
import com.cyn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: springboot-mybatis
 * @Package: com.cyn.service.impl
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/10/10 14:48
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/10/10 14:48
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
@Service
@Transactional
public class UserServiceImpl  implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        this.userMapper.insertUser(user);
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    public List<User> findUserAll() {
        return  this.userMapper.selectUserAll();
    }
}
