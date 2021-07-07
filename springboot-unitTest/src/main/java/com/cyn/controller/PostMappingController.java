package com.cyn.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-07-06
 */
@RestController
public class PostMappingController {
    @PostMapping("/postMapping")
    public String getMappingT(String t1,
                              Character t2) {
        System.out.println(t1);
        System.out.println(t2);
        return t1 + t2;
    }
}
