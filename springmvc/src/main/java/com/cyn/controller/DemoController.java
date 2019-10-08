package com.cyn.controller;

import com.cyn.bean.DemoPeople;
import com.cyn.bean.People;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

    @RequestMapping("/demo2")
    public String demo2(String name, @RequestParam("hover") List<String> hover){
        System.out.println("测试controller2demo"+name+hover);
        return "main";
    }

    @RequestMapping("/demo3")
    public String demo3(DemoPeople demoPeople){
        System.out.println("测试controller2demo"+demoPeople);
        return "main";
    }

    @RequestMapping("/demo4")
    public String demo4(String name ,String age){
        System.out.println("测试controller2demo"+name+age);
        return "main";
    }

    @RequestMapping("/demo5")
    public String demo5(){
        System.out.println("demo5");
        // 加forward:或redirect: 不走默认解析器
        return "forward:demo6";
    }

    @RequestMapping("/demo6")
    public String demo6(){
        System.out.println("demo6");
        return "main";
    }

    @RequestMapping("/demo7")
    public void demo7(HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.write("abc");
        out.flush();
        out.close();
    }


    @RequestMapping(value = "/demo8",produces = "text/html;charset=utf-8")
    @ResponseBody
    public People demo8() {
        // @ResponseBody 将返回值转化成json字符串，不跳转 ，否则跳转
        People people = new People();
        people.setAge(12);
        people.setName("张三");
        return people;
    }
    @RequestMapping(value = "/download")
    @ResponseBody
    public void download(String fileName, HttpServletResponse response, HttpServletRequest request) throws IOException {
        //字符流
        // response.getWriter();
        //字节流 设置响应中该文件进行下周
        response.setHeader("Content-Disposition","attachment;filename=bbb.txt");
        ServletOutputStream outputStream =  response.getOutputStream();
        // 资源文件夹的完整路径
        String path =  request.getServletContext().getRealPath("static");
        System.out.println(path);
        File file = new File(path,fileName);
        byte[] bytes =  FileUtils.readFileToByteArray(file);
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
    }
}