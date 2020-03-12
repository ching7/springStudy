package com.cyn.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 文件描述
 *
 * @ProjectName: springcloud-eureka
 * @Package: PACKAGE_NAME
 * @Date 2020/3/12 17:04
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
@EnableEurekaServer
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
