package com.cyn.springbootclient;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: springboot-client
 * @Package: com.cyn.springbootclient
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/10/12 10:08
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/10/12 10:08
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public void hello(){

    }
}
