package com.cyn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/4
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosPaymentProvider9002 {
    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentProvider9002.class, args);
    }
}
