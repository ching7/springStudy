package com.cyn.cloud.service;

import com.cyn.cloud.api.CommonResult;
import com.cyn.cloud.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 文件描述
 *
 * @ProjectName: springcloud
 * @Package: com.cyn.cloud.service
 * @Date 2020/3/17 11:11
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
@FeignClient(value = "user-service",fallback = UserFallbackService.class)
public interface UserService {
    @PostMapping("/user/create")
    String create(@RequestBody User user);

    @GetMapping("/user/{id}")
    String getUser(@PathVariable Long id);

    @GetMapping("/user/getByUsername")
    String getByUsername(@RequestParam String username);

    @PostMapping("/user/update")
    String update(@RequestBody User user);

    @PostMapping("/user/delete/{id}")
    String delete(@PathVariable Long id);
}
