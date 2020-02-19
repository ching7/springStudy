package com.cyn;

import com.cyn.filter.SecondFilter;
import com.cyn.listener.SecondListener;
import com.cyn.servlet.SecondServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: springboot
 * @Package: com.cyn.controller
 * @Description:
 *  springboot整合servlet，filter方式二
 *
 * @Author: hspcadmin
 * @CreateDate: 2019/10/9 15:36
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/10/9 15:36
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
@SpringBootApplication
public class ApplicationStart2 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart2.class,args);
    }

    /**
     * 通过方法注册servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());
        bean.addUrlMappings("/second");
        return bean;
    }

    /**
     * 通过方法注册filter
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean(new SecondFilter());
        //bean.addUrlPatterns(new String[]{"*.do","*.jsp"});
        bean.addUrlPatterns("/second");
        return bean;
    }
    /**
     * 通过方法注册listener
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean<SecondListener> servletListenerRegistrationBean(){
        ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean(new SecondListener());
        return bean;
    }
}
