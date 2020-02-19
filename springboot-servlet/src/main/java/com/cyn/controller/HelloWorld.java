package com.cyn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: springboot
 * @Package: com.cyn.controller
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/10/9 15:31
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/10/9 15:31
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
@Controller
public class HelloWorld {
    @RequestMapping("/hello")
    @ResponseBody
    public Map<String,Object> showHelloWorld(){
        Map<String,Object> map = new HashMap<>();
        map.put("msg","helloworld");
        return map;
    }
}
