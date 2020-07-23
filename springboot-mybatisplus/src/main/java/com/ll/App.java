package com.ll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 文件描述
 *
 * @ProjectName: springboot-mybatisplus
 * @Package: com.ll
 * @Date 2020/7/23 16:05
 * @Author:
 * @Version: 1.0
 * @Description: note
 **/
@EnableSwagger2
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
