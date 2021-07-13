package com.cyn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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

    @Value("${config.location}")
    private String[] configLocations;

    public static void main(String[] args) throws IOException {
        //springboot默认的配置文件路径
        // String addClassPath = "spring.config.location:classpath:/";
        //自定义的配置文件路径获取
        Resource resource = new ClassPathResource("application.properties");
        InputStream is = resource.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String data = null;
        while((data = br.readLine()) != null) {
            System.out.println(data);
        }

        br.close();
        isr.close();
        is.close();
        String addClassPath = "spring.config.additional-location:classpath:/application-port.properties";

        new SpringApplicationBuilder(App.class).properties(addClassPath).build().run(args);

        ///SpringApplication.run(App.class, args);
    }
}
