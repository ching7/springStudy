package com.cyn.bean;

import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserBean userBean = (UserBean) o;
        return Objects.equals(name, userBean.name) && Objects.equals(age, userBean.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
