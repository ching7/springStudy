package com.cyn.core.exception;

import com.cyn.core.dto.Response;

/**
 * @ClassName com.cyn.core.exception.BusinessException
 * @Description
 * @Author ynchen
 * @Date 2024/3/21 16:39
 * @Version V1.0.0
 */

public class BusinessException extends RuntimeException {
    private Response response;

    public BusinessException(String msg) {
        this("400", msg, msg, null);
    }

    public BusinessException(String code, String msg) {
        this(code, msg, msg, null);
    }

    public BusinessException(String code, String msg, String error) {
        this(code, msg, error, null);
    }

    public BusinessException(String code, String msg, String error, Object data) {
        super(msg);
        this.response = new Response();
        this.response.setCode(code);
        this.response.setMsg(msg);
        this.response.setError(error);
        this.response.setData(data);
    }

    public BusinessException(Response response) {
        super(response.getMessage());
        this.response = response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}