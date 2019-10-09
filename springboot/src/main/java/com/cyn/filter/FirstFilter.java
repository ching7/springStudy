package com.cyn.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: springboot
 * @Package: com.cyn.filter
 * @Description:
 *
 * springboot整合filter 方式一
 * 1.web.xml形式
 * <filer>
 *     <filter-name></filter-name>
 *     <filter-class></filter-class>
 * </filer>
 * <filter-mapping>
 *     <filter-name></filter-name>
 *     <url-pattern></url-pattern>
 * </filter-mapping>
 * 2.注解形式
 *
 * @Author: hspcadmin
 * @CreateDate: 2019/10/9 16:29
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/10/9 16:29
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
//@WebFilter(filterName = "FirstFilter",urlPatterns = {"*.do","*.jsp"})
@WebFilter(filterName = "FirstFilter",urlPatterns = "/first")

public class FirstFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入filter");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("放行");
    }

    @Override
    public void destroy() {

    }
}
