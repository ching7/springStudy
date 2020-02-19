package com.cyn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 文件描述
 *
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
 **/
@Controller
public class DemoController2 {
    @RequestMapping("/demo")
    public String demo(){
        System.out.println("执行注解Controller");
        return "/main.jsp";
    }
}
