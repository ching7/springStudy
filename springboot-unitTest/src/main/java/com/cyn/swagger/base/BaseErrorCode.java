package com.cyn.swagger.base;

import io.swagger.annotations.ApiModel;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-11-29
 */
@ApiModel(value = "BaseErrorCode", description = "")
public class BaseErrorCode {
    /**
     * 状态类型
     */
    public static class Common {
        /**
         * 成功
         */
        public static final IMessage SUCCESS = new IMessage("200", "成功");

        public static final IMessage UNKNOWN_ERROR = new IMessage("500", "成功");;
    }
}
