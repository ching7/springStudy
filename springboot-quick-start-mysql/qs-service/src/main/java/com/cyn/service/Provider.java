package com.cyn.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 文件描述
 *
 * @ProjectName: springboot-quick-start
 * @Package: PACKAGE_NAME
 * @Date 2020/7/10 11:00
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
@SpringBootApplication
@ComponentScan(basePackages = {"com.cyn.*"})
public class Provider {
    public static void main(String[] args) {
        SpringApplication.run(Provider.class, args);
    }
}
