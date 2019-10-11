package com.cyn.Dao;

import org.springframework.stereotype.Repository;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: springboot-unitTest
 * @Package: com.cyn.Dao
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/10/11 11:35
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/10/11 11:35
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
@Repository
public class UserDaoImpl {
    public void saveUser(){
        System.out.println("添加用户");
    }
}
