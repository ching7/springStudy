package com.cyn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author chenyn
 * @version 1.0
 * @date 2019/10/10 22:11
 */
@Controller
public class UserController {

    /**
     * 视图跳转
     * 解决异常的方法：
     * 由于springmvc会将该对象放入到modelAndView中传递,以类名的驼峰命名作为key
     * 参数名称必须与对象名称相同，类名首字母小写
     *
     * 或者用@ModelAttribute
     * @param
     * @return
     */
    @RequestMapping("/show")
    public String showPage(){
        int  a  = 10/0;
        return "add";
    }

    @RequestMapping("/show1")
    public String showPage1(){
        String   a  = null;
        a.length();
        return "add";
    }
}
