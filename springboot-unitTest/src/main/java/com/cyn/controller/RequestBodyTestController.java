package com.cyn.controller;

import com.cyn.bean.UserBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-06-17
 */
@RestController
public class RequestBodyTestController {
    @PostMapping("addUser")
    public Object addProject(@RequestBody UserBean userBean, String testT, HttpServletRequest request) {
        // requestBody 外的入参无法接受
        return userBean + testT;
    }
}
