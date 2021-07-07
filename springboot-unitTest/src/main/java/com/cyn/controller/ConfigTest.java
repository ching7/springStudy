package com.cyn.controller;

import org.apache.bcel.util.ClassPath;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-07-07
 */
@RestController
public class ConfigTest {
    @Value("${my.name:'12'}")
    private String name;

    @GetMapping("getName")
    public String getName() {
        return name;
    }
}
