package com.cyn.strategypattern.controller;

import com.cyn.strategypattern.Strategy;
import com.cyn.strategypattern.service.SimpleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 文件描述
 *
 * @ProjectName: springboot-design-pattern
 * @Package: com.cyn.strategypattern.controller
 * @Date 2020/9/8 15:21
 * @Author:
 * @Version: 1.0
 * @Description: note
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private SimpleContext simpleContext;

    @GetMapping("/choose")
    public Strategy choose(@RequestParam String poolId) {
        Strategy strategy = simpleContext.getResource(poolId);
        return strategy;
    }


    @GetMapping("/choose2")
    public Strategy choose2(@RequestParam String poolId) {
        Strategy strategy = simpleContext.getResource(poolId);

        return strategy;
    }

}
