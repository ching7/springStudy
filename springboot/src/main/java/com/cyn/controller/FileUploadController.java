package com.cyn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: springboot
 * @Package: com.cyn.controller
 * @Description:
 *
 * springboot文件上传
 *
 * @Author: hspcadmin
 * @CreateDate: 2019/10/9 17:17
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/10/9 17:17
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
//@Controller
@RestController // 该类下的所有方法返回为json，可以理解为@Controller @RequestBody 复合注解
public class FileUploadController {
    /**
     * 文件上传(上传默认10mb)
     * @param filename
     * @return
     */
    @RequestMapping("/fileUploadController")
    public Map<String, Object> fileUpload(MultipartFile filename) throws IOException {

        Map<String,Object> map = new HashMap<>();
        System.out.println(filename.getOriginalFilename());
        filename.transferTo(new File("E:/"+filename.getOriginalFilename()));
        map.put("msg","OK");
        return map;
    }
}
