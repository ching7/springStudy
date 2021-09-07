package com.cyn.service;

import com.cyn.Dao.UserDao;
import com.cyn.bean.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-09-07
 */
@Service("UserServiceImpl2")
public class UserServiceImpl2 implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public void addUser() {
        System.out.println("UserServiceImpl2");
        userDao.saveUser();
    }

    @Override
    public UserBean getUser() {
        return null;
    }
}
