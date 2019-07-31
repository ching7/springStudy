package com.cyn.test;

import com.cyn.bean.People;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: spring01-runtime
 * @Package: com.cyn.Test
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/7/31 14:19
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/7/31 14:19
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Test {
    public static void main(String[] args) {
        /*People people = new People("cyn",2222);
        System.out.println(people);*/
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        People people =  ac.getBean("people",People.class);
        System.out.println(people);
    }
}
