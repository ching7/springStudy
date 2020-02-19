package com.cyn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 文件描述
 *
 * @ProjectName: springboot-exception
 * @Package: com.cyn.controller
 * @Description: note
 * @CreateDate: 2019/10/11 10:58
 * @UpdateDate: 2019/10/11 10:58
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 **/
@Controller
public class DemoController {
    @RequestMapping("/showUser1")
    public String showUser1(){
        int  a  = 10/0;
        return "add";
    }

    @RequestMapping("/showUser2")
    public String showUser2(){
        String   a  = null;
        a.length();
        return "add";
    }
}
