package com.cyn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * 文件描述
 *
 * @ProjectName: springboot-unitTest
 * @Package: com.cyn
 * @Description: note
 * @Author: admin
 * @CreateDate: 2019/10/11 11:41
 * @UpdateDate: 2019/10/11 11:41
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 **/
@SpringBootApplication
//@PropertySources({
//        @PropertySource(value = "application-cyn.properties", ignoreResourceNotFound = true)
//})
public class App {
    public static void main(String[] args) {
        //springboot默认的配置文件路径
        // String addClassPath = "spring.config.location:classpath:/";
        //自定义的配置文件路径
        // String addClassPath = "spring.config.additional-location:classpath:/application-port.properties";
        //new SpringApplicationBuilder(App.class).properties(addClassPath).build().run(args);
        SpringApplication.run(App.class, args);
    }
}
