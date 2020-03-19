package com.cyn.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件描述
 *
 * @ProjectName: springcloud
 * @Package: com.cyn.cloud.controller
 * @Date 2020/3/19 14:32
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
@RestController
public class ConfigClientController {

    @Value("${config.info:config-default}")
    private String config;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return config;
    }
}