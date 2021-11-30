package com.cyn.swagger;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-11-30
 */
public class ResponseCode {
    public static final Map<Integer,String> MESSAGE_MAP = Maps.newHashMap();
    //初始化状态码与文字说明
    static {
        /* 成功状态码 */
        MESSAGE_MAP.put(200, "成功");

        /* 服务器错误 */
        MESSAGE_MAP.put(1000,"服务器错误");

        /* 参数错误：10001-19999 */
        MESSAGE_MAP.put(10001, "参数无效");
        MESSAGE_MAP.put(10002, "参数为空");
        MESSAGE_MAP.put(10003, "参数类型错误");
        MESSAGE_MAP.put(10004, "参数缺失");

        /* 用户错误：20001-29999*/
        MESSAGE_MAP.put(20001, "用户未登录");
        MESSAGE_MAP.put(20002, "账号不存在或密码错误");
        MESSAGE_MAP.put(20003, "账号已被禁用");
        MESSAGE_MAP.put(20004, "用户不存在");
        MESSAGE_MAP.put(20005, "用户已存在");

        /* 业务错误：30001-39999 */
        MESSAGE_MAP.put(30001, "某业务出现问题");

        /* 系统错误：40001-49999 */
        MESSAGE_MAP.put(40001, "系统繁忙，请稍后重试");

        /* 数据错误：50001-599999 */
        MESSAGE_MAP.put(50001, "数据未找到");
        MESSAGE_MAP.put(50002, "数据有误");
        MESSAGE_MAP.put(50003, "数据已存在");
        MESSAGE_MAP.put(50004,"查询出错");

        /* 接口错误：60001-69999 */
        MESSAGE_MAP.put(60001, "内部系统接口调用异常");
        MESSAGE_MAP.put(60002, "外部系统接口调用异常");
        MESSAGE_MAP.put(60003, "该接口禁止访问");
        MESSAGE_MAP.put(60004, "接口地址无效");
        MESSAGE_MAP.put(60005, "接口请求超时");
        MESSAGE_MAP.put(60006, "接口负载过高");

        /* 权限错误：70001-79999 */
        MESSAGE_MAP.put(70001, "无权限访问");
    }
}
