package com.cyn.controller;

import com.cyn.bean.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: springboot-view-jsp
 * @Package: com.cyn.controller
 * @Description:
 *
 * springboot整合jsp
 *
 * @Author: hspcadmin
 * @CreateDate: 2019/10/9 19:23
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/10/9 19:23
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
@Controller
public class UserController {
    @RequestMapping("/userListController")
    public String showUser(Model model){
        List<Users> list = new ArrayList<>();
        list.add(new Users(1,"张三",12));
        list.add(new Users(2,"李四",13));
        list.add(new Users(3,"王五",14));
        model.addAttribute("list",list);
        return "userList";
    }
}
