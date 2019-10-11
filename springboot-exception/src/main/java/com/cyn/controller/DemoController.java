package com.cyn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: springboot-exception
 * @Package: com.cyn.controller
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/10/11 10:58
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/10/11 10:58
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
@Controller
public class DemoController {
    @RequestMapping("/showUser1")
    public String showUser1(){
        int  a  = 10/0;
        return "add";
    }

    @RequestMapping("/showUser2")
    public String showUser2(){
        String   a  = null;
        a.length();
        return "add";
    }
}
