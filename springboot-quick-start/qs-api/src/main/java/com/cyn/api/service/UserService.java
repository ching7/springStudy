package com.cyn.api.service;

import com.cyn.api.entity.MyUser;

/**
 * 文件描述
 *
 * @ProjectName: springboot-quick-start
 * @Package: com.cyn.serviceimpl
 * @Date 2020/7/10 10:58
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public interface UserService {
    /**
     * 获取用户信息
     *
     * @return
     */
    MyUser getUserInfo();
}
