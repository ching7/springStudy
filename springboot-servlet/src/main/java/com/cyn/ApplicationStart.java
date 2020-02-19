package com.cyn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: springboot
 * @Package: com.cyn.controller
 * @Description:
 *
 * springboot整合servlet，filter方式一
 *
 * @Author: hspcadmin
 * @CreateDate: 2019/10/9 15:36
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/10/9 15:36
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
@SpringBootApplication
@ServletComponentScan  //在springboot启动时会扫描@webServlet @webFilter @WebListener，实例化该类
public class ApplicationStart {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart.class,args);
    }
}
