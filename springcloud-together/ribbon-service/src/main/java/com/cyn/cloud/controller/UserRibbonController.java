package com.cyn.cloud.controller;

import com.cyn.cloud.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * 文件描述
 *
 * @ProjectName: springcloud
 * @Package: com.cyn.cloud.controller
 * @Date 2020/3/12 19:54
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: UserRibbonController类
 * 注入RestTemplate，使用其调用user-service中提供的相关接口，这里对GET和POST调用进行了演示
 **/
@RestController
@RequestMapping("/user")
public class UserRibbonController {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${service-url.user-service}")
    private String userServiceUrl;

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id) {
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", String.class, id);
    }

    @GetMapping("/getByUsername")
    public String getByUsername(@RequestParam String username) {
        return restTemplate.getForObject(userServiceUrl + "/user/getByUsername?username={1}", String.class, username);
    }

    @GetMapping("/getEntityByUsername")
    public String getEntityByUsername(@RequestParam String username) {
        ResponseEntity<String> entity = restTemplate.getForEntity(userServiceUrl + "/user/getByUsername?username={1}", String.class, username);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return "操作失败";
        }
    }

    @PostMapping("/create")
    public String create(@RequestBody User user) {
        return restTemplate.postForObject(userServiceUrl + "/user/create", user, String.class);
    }

    @PostMapping("/update")
    public String update(@RequestBody User user) {
        return restTemplate.postForObject(userServiceUrl + "/user/update", user, String.class);
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return restTemplate.postForObject(userServiceUrl + "/user/delete/{1}", null, String.class, id);
    }
}
