package com.cyn.service;

import com.cyn.Dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: springboot-unitTest
 * @Package: com.cyn.service
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/10/11 11:36
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/10/11 11:36
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
@Service
public class UserServiceImpl {

    @Autowired
    private UserDaoImpl userDao;

    public void addUser(){
        userDao.saveUser();
    }
}
