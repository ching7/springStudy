package com.cyn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/2
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class StreamMq8803Main {
    public static void main(String[] args) {
        SpringApplication.run(StreamMq8803Main.class, args);
    }
}
