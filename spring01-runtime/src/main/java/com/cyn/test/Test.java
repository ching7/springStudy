package com.cyn.test;

import com.cyn.bean.Man;
import com.cyn.bean.People;
import com.cyn.bean.PeopleFactory;
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
        /**
         * spring 创建对象的3个方法
         *
         */
        /*People people = new People("cyn",2222);
        System.out.println(people);*/
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        People people =  ac.getBean("people",People.class);
        PeopleFactory pf = new PeopleFactory();
        People people1 =  pf.createPeople('A');
        System.out.println(people);
        System.out.println(people1);

        /**
         * 对象赋值
         */
        Man man = ac.getBean("man", Man.class);
        System.out.println(man);

    }
}
