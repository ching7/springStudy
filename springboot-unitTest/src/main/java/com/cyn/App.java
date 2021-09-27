package com.cyn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.env.PropertiesPropertySourceLoader;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

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
@EnableAspectJAutoProxy
//@PropertySources({
//        @PropertySource(value = "application-cyn.properties", ignoreResourceNotFound = true)
//})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
