package com.cyn.test;

import com.cyn.bean.People;


/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: java-reflect
 * @Package: com.cyn.test
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/9/25 19:56
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/9/25 19:56
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 传统方式创建类对象
        People people = new People();

        // 反射创建类对象
        Class cla =  Class.forName("com.cyn.bean.People");
        Object obj = cla.newInstance();
        System.out.println(obj.getClass().getPackage());
        System.out.println(obj.getClass().getAnnotation(Deprecated.class));

    }
}
