package com.cyn.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-07-06
 */
@RestController
public class PostMappingController {
    @PostMapping("/postMapping")
    //@PerfLog
    public String getMappingT(String t1,
                              Character t2) {
        System.out.println(t1);
        System.out.println(t2);
        return t1 + t2;
    }

    @PostMapping("/uploadFileTest")
    //@PerfLog
    public Object uploadFileTest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        //获取文件上传的真实路径
        String uploadPath = request.getSession().getServletContext().getRealPath("/");
        //保存文件的路径
        String filepath = File.separator + UUID.randomUUID();
        File destfile = new File(uploadPath + filepath);
        if (!destfile.exists()) {
            destfile.mkdirs();
        }
        //文件新名称
        String fileNameNew = "1.wav";
        File f = new File(destfile.getAbsoluteFile() + File.separator + fileNameNew);
        if (!f.exists()) {
            OutputStream os = new FileOutputStream(f);
            BufferedOutputStream bos = new BufferedOutputStream(os);

            byte[] buf = new byte[1024];
            int length;
            length = inputStream.read(buf, 0, buf.length);

            while (length != -1) {
                bos.write(buf, 0, length);
                length = inputStream.read(buf);
            }
            bos.close();
            os.close();
            inputStream.close();
            String lastpath = filepath + File.separator + fileNameNew;
            System.out.println("返回图片路径：" + lastpath);
            return lastpath;
        }
        return false;
    }
}
