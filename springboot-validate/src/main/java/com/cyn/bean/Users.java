package com.cyn.bean;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author chenyn
 * @version 1.0
 * @date 2019/10/10 22:10
 */
public class Users {
    @NotBlank(message = "姓名不能为空")
    private String name;
    @NotBlank(message = "密码不能为空")
    private String password;
    private Integer age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Users [name=" + name + ", password=" + password + ", age="
                + age + "]";
    }
}
