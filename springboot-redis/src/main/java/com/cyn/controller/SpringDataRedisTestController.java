package com.cyn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author chenyanan
 */
@RestController
public class SpringDataRedisTestController {

    @Autowired
    StringRedisTemplate redisTemplate;

    /**
     * description: testRedisSet 测试redis设置缓存<br>
     *
     * @return java.lang.String
     * @version: 1.0 <br>
     * @date: 2022/7/21 21:59 <br>
     * @author: William <br>
     */
    @GetMapping("redisSet")
    public String testRedisSet() {
        redisTemplate.opsForValue().set("test:redis:userName", "张三", 120, TimeUnit.SECONDS);
        return "OK";
    }


    @GetMapping("redisGet")
    public String testRedisGet() {
        String name = redisTemplate.opsForValue().get("test:redis:userName");
        return name;
    }
}