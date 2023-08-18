package com.cyn.service.serviceimpl;

import com.cyn.api.entity.MyUser;
import com.cyn.api.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 文件描述
 *
 * @ProjectName: springboot-quick-start
 * @Package: com.cyn.service.serviceimpl
 * @Date 2020/7/10 11:07
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
@Service
public class UserServiceImpl implements UserService {
    /**
     * 获取用户信息
     *
     * @return
     */
    @Override
    public MyUser getUserInfo() {
        return new MyUser("张三",25);
    }
}
