package com.cyn.core.dto;
import java.io.Serializable;

/**
 * @ClassName Response
 * @Description
 * @Author ynchen
 * @Date 2024/3/21 16:42
 * @Version V1.0.0
 */


public class Response<T> implements Serializable {
    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return "Response(code=" + getCode() + ", msg=" + getMsg() + ", error=" + getError() + ", data=" + getData() + ")";
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Response))
            return false;
        Response<?> other = (Response) o;
        if (!other.canEqual(this))
            return false;
        Object this$code = getCode(), other$code = other.getCode();
        if ((this$code == null) ? (other$code != null) : !this$code.equals(other$code))
            return false;
        Object this$msg = getMsg(), other$msg = other.getMsg();
        if ((this$msg == null) ? (other$msg != null) : !this$msg.equals(other$msg))
            return false;
        Object this$error = getError(), other$error = other.getError();
        if ((this$error == null) ? (other$error != null) : !this$error.equals(other$error))
            return false;
        Object this$data = getData(), other$data = other.getData();
        return !((this$data == null) ? (other$data != null) : !this$data.equals(other$data));
    }

    protected boolean canEqual(Object other) {
        return other instanceof Response;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $code = getCode();
        result = result * 59 + (($code == null) ? 43 : $code.hashCode());
        Object $msg = getMsg();
        result = result * 59 + (($msg == null) ? 43 : $msg.hashCode());
        Object $error = getError();
        result = result * 59 + (($error == null) ? 43 : $error.hashCode());
        Object $data = getData();
        return result * 59 + (($data == null) ? 43 : $data.hashCode());
    }

    protected String code = "200";

    public String getCode() {
        return this.code;
    }

    protected String msg = "success";

    public String getMsg() {
        return this.msg;
    }

    protected String error = "success";

    protected T data;

    public String getError() {
        return this.error;
    }

    public T getData() {
        return this.data;
    }

    public Response(T data) {
        this.data = data;
    }

    public Response(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(String code, String msg, String errorMsg) {
        this.code = code;
        this.msg = msg;
        this.error = errorMsg;
    }

    public Response(String code, String msg, String errorMsg, T data) {
        this.code = code;
        this.msg = msg;
        this.error = errorMsg;
        this.data = data;
    }

    public String getMessage() {
        return this.msg;
    }

    public Response() {
    }
}
