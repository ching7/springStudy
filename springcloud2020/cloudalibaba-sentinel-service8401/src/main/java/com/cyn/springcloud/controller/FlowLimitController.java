package com.cyn.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/8
 */
@RestController
public class FlowLimitController {
    @GetMapping(value = "/testA")
    public String testA() throws InterruptedException {
        return "--testA";
    }

    @GetMapping(value = "/testB")
    public String testB() {
        return "--testB";
    }
}
