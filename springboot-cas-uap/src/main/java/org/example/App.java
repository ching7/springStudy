package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = RedisAutoConfiguration.class)
@ComponentScan(basePackages = {"org.example", "com.iflytek.sec.uap.util.config", "com.iflytek.sec.uap.client.rest.cache.memory"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
