package com.cyn.config;

import com.cyn.websocket.WsTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-06-11
 */
@Configuration
public class WsClientBeanConfig {
    @Bean(initMethod = "init")
    public WsTest initWsTest() {
        return new WsTest();
    }
}
