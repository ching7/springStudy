package com.cyn.controller;

import com.cyn.bean.People;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class DemoController {

    @RequestMapping("/index")
    public String index(){
        System.out.println("测试controller");
        return "index";
    }

    @RequestMapping("/demo")
    public String demo(@RequestParam(value = "name1",required = true) String name, @RequestParam(defaultValue = "2") int age){
        System.out.println("测试controller2demo"+name+age);
        return "main";
    }
}