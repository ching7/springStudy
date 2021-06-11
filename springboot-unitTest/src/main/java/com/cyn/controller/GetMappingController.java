package com.cyn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
                              @PathVariable String t2) {
        return t1 + t2;
    }
}
