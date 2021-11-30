package com.cyn.swagger.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-11-29
 */
@ApiModel(value = "IMessage", description = "")
public class IMessage {
    @ApiModelProperty(value = "", required = true)
    private String code;
    @ApiModelProperty(value = "", required = true)
    private String message;

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

    public IMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
