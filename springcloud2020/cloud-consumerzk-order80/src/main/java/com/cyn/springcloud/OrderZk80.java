package com.cyn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/11/14
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class OrderZk80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZk80.class, args);
    }
}