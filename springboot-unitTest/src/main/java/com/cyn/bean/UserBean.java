package com.cyn.bean;

import java.io.Serializable;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-06-08
 */
public class UserBean implements Serializable {
    private String name;
    private String age;
    private static final long SerializableId = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public UserBean(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
