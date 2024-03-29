package com.cyn.swagger;

import com.cyn.swagger.base.BaseErrorCode;
import com.cyn.swagger.base.IMessage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-11-30
 */
@ApiModel(value = "ResultDataStd", description = "")
public class ResultDataStd<T> extends ResultDataBase<T> {
    @ApiModelProperty(value = "", required = true)
    private static final long serialVersionUID = -7268040542410707954L;

    public ResultDataStd() {

    }

    public ResultDataStd(boolean success, String message) {
        this.setSuccess(success);
        this.setMessage(message);
    }

    public ResultDataStd(boolean success) {
        this.setSuccess(success);
    }

    public ResultDataStd(String code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    public ResultDataStd(boolean success, String message, T data) {
        this.setSuccess(success);
        this.setMessage(message);
        this.setData(data);
    }

    public static ResultDataStd ok() {
        return ok(BaseErrorCode.Common.SUCCESS);
    }

    public static <T> ResultDataStd<T> ok(IMessage msg) {
        return baseCreate(msg.getCode(), msg.getMessage(), true);
    }

    public static ResultDataStd fail() {
        return fail(BaseErrorCode.Common.UNKNOWN_ERROR);
    }

    public static ResultDataStd fail(IMessage message) {
        return fail(message.getCode(), message.getMessage());
    }

    public static ResultDataStd fail(String code, String msg) {
        return baseCreate(code, msg, false);
    }

    private static <T> ResultDataStd<T> baseCreate(String code, String msg, boolean success) {
        ResultDataStd<T> result = new ResultDataStd<T>();
        result.setCode(code);
        result.setSuccess(success);
        result.setMessage(msg);
        result.setTimestamp(new Date().toString());
        return result;
    }

    public ResultDataStd<T> setResultData(T data) {
        this.setData(data);
        return this;
    }

    @Override
    public T getData() {
        return (T) super.getData();
    }
}
