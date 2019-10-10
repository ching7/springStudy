package com.cyn.service;

import com.cyn.bean.User;

import java.util.List;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: springboot-mybatis
 * @Package: com.cyn.service
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/10/10 14:47
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/10/10 14:47
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public interface UserService {
    /**
     * 用户添加
     * @param user
     */
    void addUser(User user);

    /**
     * 查询所有用户
     * @return
     */
    List<User> findUserAll();
}
