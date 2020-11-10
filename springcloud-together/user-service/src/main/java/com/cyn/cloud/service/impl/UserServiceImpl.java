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
    public String create(User user) {
        User u = new User(1,"新增","test");
        return u.toString();
    }

    @Override
    public String getUser(Long id) {
        User u = new User(1,"获取","test");
        return u.toString();
    }

    @Override
    public String getUserByIds(List<Long> ids) {
        List<User> list = new ArrayList<>();
        list.add(new User(1,"test","test"));
        return list.toString();
    }

    @Override
    public String getByUsername(String username) {
        User u = new User(1,"getByUsername","test");
        return u.toString();
    }

    @Override
    public String update(User user) {
        User u = new User(1,"修改","test");
        return u.toString();
    }

    @Override
    public String delete(Long id) {
        User u = new User(1,"删除","test");
        return u.toString();
    }
}
