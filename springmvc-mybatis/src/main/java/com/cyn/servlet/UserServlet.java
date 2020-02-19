package com.cyn.servlet;

import com.cyn.service.UserService;
import com.cyn.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        //实例化service
        //ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //spring 和tomcat的web.xml整合后，信息都存放在webApplicationContext
        ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        userService = ac.getBean("userService",UserServiceImpl.class);
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String uname =  (String)req.getParameter("username");
        String pwd = (String)req.getParameter("password");
        String validCodeInput = (String)req.getParameter("validCode");
        String validCode =  (String)req.getSession().getAttribute("validCode");
        System.out.println(uname+" : "+ pwd+":"+validCodeInput+":"+validCode);
        req.setAttribute("list",userService.showAllUser());
        req.getRequestDispatcher("index.jsp").forward(req,res);
    }
}
