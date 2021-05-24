package com.cyn.bean;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-05-24
 */
public enum RoleNum {
    BUYER(1, "顾客"),
    SELLER(2, "商家"),
    RIDER(3, "骑手"),
    ;
    Integer code;
    String message;

    RoleNum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
