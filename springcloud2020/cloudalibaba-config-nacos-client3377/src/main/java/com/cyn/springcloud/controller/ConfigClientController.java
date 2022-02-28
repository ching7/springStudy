package com.cyn.springcloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.cyn.springcloud.config.SysInitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/7
 */
@RestController
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @Autowired
    SysInitParam sysInitParam;

    @GetMapping(value = "/config/info")
    public String getConfigInfo() {
        return configInfo;
    }

    @GetMapping("/sysConfig/get/sysInitParam")
    public Object getSysInitParam() {
        return JSONObject.toJSONString(sysInitParam);
    }
}
