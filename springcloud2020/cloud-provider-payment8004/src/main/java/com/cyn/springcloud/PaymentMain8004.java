package com.cyn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/11/14
 */
@EnableDiscoveryClient //该注解用于向使用consul或者zookeeper作为注册中心时注册服务
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
