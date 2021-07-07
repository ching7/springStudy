package com.cyn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: springboot-unitTest
 * @Package: com.cyn
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/10/11 11:41
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/10/11 11:41
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
@SpringBootApplication
//@PropertySources({
//        @PropertySource(value = "application-cyn.properties", ignoreResourceNotFound = true)
//})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
