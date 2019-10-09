package com.cyn.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: springboot
 * @Package: com.cyn.listener
 * @Description:
 *
 * springBoot整合listener
 * 1.web.xml配置
 * <listener>
 *     <listener-class></listener-class>
 * </listener>
 *
 * @Author: hspcadmin
 * @CreateDate: 2019/10/9 16:51
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/10/9 16:51
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class SecondListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("SecondListener ----- init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
