package com.cyn.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/11/30
 */
// 刷新配置
@RefreshScope
@RestController
public class ConfigClientController {

    @Value("${server.port:8080}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return serverPort + ": // " + configInfo;
    }
}
