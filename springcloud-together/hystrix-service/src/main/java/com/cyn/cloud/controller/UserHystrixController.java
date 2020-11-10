package com.cyn.cloud.controller;

import com.cyn.cloud.bean.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 文件描述
 *
 * @ProjectName: springcloud
 * @Package: com.cyn.cloud.controller
 * @Date 2020/3/13 12:36
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
@RestController
@RequestMapping("/userhy")
public class UserHystrixController {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${service-url.user-service}")
    private String userServiceUrl;

    @HystrixCommand(fallbackMethod = "getDefaultUser",
            ignoreExceptions = NullPointerException.class,
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2200")})
    @GetMapping("/testCommand/{id}")
    public String testCommand(@PathVariable Long id) {
        if (id == 1) {
            throw new IndexOutOfBoundsException();
        } else if (id == 2) {
            throw new NullPointerException();
        }
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", String.class, id);
    }

    /**
     * 服务降级方法
     * @param id
     * @return
     */
    public String getDefaultUser(@PathVariable Long id) {
        User defaultUser = new User(-1, "defaultUser", "123456");
        return defaultUser.toString();
    }
}
