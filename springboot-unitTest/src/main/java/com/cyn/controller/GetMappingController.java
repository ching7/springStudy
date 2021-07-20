package com.cyn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-06-11
 */
@RestController
public class GetMappingController {
    @GetMapping("/getMapping/{t1}/{t2}")
    public String getMappingT(@PathVariable String t1,
                              @PathVariable String t2,
                              @RequestParam int status,
                              @RequestParam(required = false) String keyword) {
        // @PathVariable 这种路径写法会导致参数必传
        return t1 + t2 + status + keyword;
    }
}
