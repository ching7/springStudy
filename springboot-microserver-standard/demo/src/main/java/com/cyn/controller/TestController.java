package com.cyn.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-05-27
 */
@RestController()
public class TestController {
    /**
     * /版本/访问控制/域对象
     * /版本/访问控制/域对象/动作
     * GET /v1/pb/tickets # 获取ticket列表
     * GET /v1/pb/tickets/12 # 查看某个具体的ticket
     * POST /v1/pb/tickets # 新建一个ticket
     * PUT /v1/pb/tickets/12 # 更新ticket 12.
     * DELETE /tickets/12 #删除ticekt 12
     *
     * pb - public 所有请求均可访问
     * pt - protected 需要进行token认证通过后方可访问
     * df - default 网关进行token认证 并且请求参数和返回结果进行加解密
     * 修改为请求头含有X-Encrypt=v1时，网关对请求结果和返回响应进行v1版本加解密算法( 算法为 base64(aes(body)) )，对请求解密和对响应加密
     * pv - private 无法通过网关访问 只能微服务内部调用
     *
     *
     * 微服务间调用(讨论结果：确定采用api(sdk)方式调用)
     * 建议微服务间调用采用服务提供方提供的SDK jar包调用，而不是直接使用url调用，以便统计服务消费者以及接口升级（sdk jar包版本升级）。
     */

    /**
     * 查询
     *
     * @param id
     * @return
     */
    @GetMapping("/v1/pb/test/{id}")
    public String getTestContent(@PathVariable("id") String id) {
        return "get:" + id;
    }

    /**
     * 新增
     *
     * @param testId
     * @return
     */
    @PostMapping("/v1/pt/test")
    public String addTestContent(String testId) {
        return "add:" + testId;
    }

    /**
     * 修改
     *
     * @param testId
     * @param name
     * @return
     */
    @PutMapping("/v1/df/test/{id}/{name}")
    public String putTestContent(@PathVariable("id") String testId,
                                 @PathVariable("name") String name) {
        return "put:" + testId + "," + name;
    }

    /**
     * 修改
     *
     * @param testId
     * @param name
     * @return
     */
    @PatchMapping("/v1/df/test/{id}/{name}/{sex}")
    public String putTestContent(@PathVariable("id") String testId,
                                 @PathVariable("name") String name,
                                 @PathVariable("sex") String sex) {
        return "put:" + testId + "," + name;
    }

    /**
     * 删除
     *
     * @param testId
     * @return
     */
    @DeleteMapping("/v1/dv/test/{id}")
    public String delTestContent(@PathVariable("id") String testId) {
        return "del:" + testId;
    }

    /**
     * 版本输入
     *
     * @param id
     * @return
     */
    @GetMapping("/{version}/pb/test/{id}")
    public String getTestContent(@PathVariable("version") String version, @PathVariable("id") String id) {
        if ("v1".equals(version)) {
            return " v1 get:" + id;
        } else if ("v2".equals(version)) {
            return " v2 get:" + id;
        }
        return version + " get:" + id;
    }
}
