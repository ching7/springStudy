package com.cyn.bean;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: spring01-runtime
 * @Package: com.cyn.bean
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/7/31 14:05
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/7/31 14:05
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class People {
    private String name;
    private  Integer age;

    public People(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
