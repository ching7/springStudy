package com.cyn.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cyn.bean.UserBean;
import org.json.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-07-06
 */
@RestController
public class JsonController {

    @GetMapping("getJson")
    public void getExcel(HttpServletRequest request, HttpServletResponse httpResponse) throws IOException {
        generateDownloadTemplate(httpResponse, request);
    }

    private void generateDownloadTemplate(HttpServletResponse response, HttpServletRequest request) throws IOException {

        try {
            response.setContentType("application/octet-stream;charset=UTF-8");
            //默认Excel名称
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("test.json", "UTF-8"));
            response.flushBuffer();
            UserBean lisi = new UserBean("lisi", "123");
            response.getOutputStream().write(JSON.toJSONString(lisi).getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
