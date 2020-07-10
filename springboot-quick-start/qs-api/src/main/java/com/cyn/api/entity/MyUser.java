package com.cyn.api.entity;

import lombok.Data;

/**
 * 文件描述
 *
 * @ProjectName: springboot-quick-start
 * @Package: com.cyn.entity
 * @Date 2020/7/10 10:57
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
@Data
public class MyUser {
    private String name;
    private int age;

    public MyUser(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
