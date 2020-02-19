package com.cyn;

import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: springboot-mybatis
 * @Package: com.cyn
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/10/10 14:58
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/10/10 14:58
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
@SpringBootApplication
@MapperScan("com.cyn.mapper") //@MapperScan 用于springboot扫描mybatis的mapper接口
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
    @Test
    public void hello(){
        System.out.println("hello");
    }
}
