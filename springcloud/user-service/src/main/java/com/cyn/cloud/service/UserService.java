package com.cyn.cloud.service;

import com.cyn.cloud.bean.User;

import java.util.List;

/**
 * 文件描述
 *
 * @ProjectName: springcloud
 * @Package: com.cyn.cloud.service
 * @Date 2020/3/12 20:18
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: 用户服务接口
 **/
public interface UserService {
    void create(User user);

    User getUser(Long id);

    List<User> getUserByIds(List<Long> ids);

    User getByUsername(String username);

    void update(User user);

    void delete(Long id);
}
