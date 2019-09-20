package com.cyn.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: springStudy
 * @Package: com.cyn.controller
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/9/20 16:11
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/9/20 16:11
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class DemoController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("执行springMVC controller控制器");
        return null;
    }
}
