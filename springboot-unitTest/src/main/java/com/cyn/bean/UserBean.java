package com.cyn.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-06-08
 */
@ApiModel(value = "UserBean", description = "用户")
public class UserBean implements Serializable {
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称", required = true)
    private String name;
    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
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
