package com.cyn.springbootfastbuild;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: springboot-fastbuild
 * @Package: com.cyn.controller
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/10/11 19:20
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/10/11 19:20
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
@RestController
public class HelloController {


    @Value("${msg:test}")
    private String msg;

    @RequestMapping("/hello")
    public String showMsg(){
        return this.msg;
    }
}
