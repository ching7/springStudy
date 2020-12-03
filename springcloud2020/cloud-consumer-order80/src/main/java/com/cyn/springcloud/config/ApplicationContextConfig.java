package com.cyn.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/11/11
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced // 自注解会和自定义负载冲突，需要自定义负载时，注释
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
