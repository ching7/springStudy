package com.cyn.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: springboot
 * @Package: com.cyn.servlet
 * @Description:
 *
 * springboot整合servlet方式一
 *
 * 1.web.xml配置
 * <servlet>
 *     <servlet-name></servlet-name>
 *     <servlet-class></servlet-class>
 * </servlet>
 * <servlet-mapping>
 *     <servlet-name></servlet-name>
 *     <url-pattern></url-pattern>
 * </servlet-mapping>
 * 2.注解
 * # @WebServlet(name = "FirstServlet",urlPatterns = "/first")
 *
 * @Author: hspcadmin
 * @CreateDate: 2019/10/9 16:02
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/10/9 16:02
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
@WebServlet(name = "FirstServlet",urlPatterns = "/first")
public class FirstServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("firstServlet!!!");
    }
}
