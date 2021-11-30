package com.cyn.swagger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-11-30
 */
@ApiModel(value = "返回说明")
public class ResultData<T> {

    @ApiModelProperty(value = "成功标识；true：成功；false:失败")
    private boolean success;

    @ApiModelProperty(value = "返回状态码；200:成功")
    private String code;

    @ApiModelProperty(value = "描述信息")
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private T data;
}
