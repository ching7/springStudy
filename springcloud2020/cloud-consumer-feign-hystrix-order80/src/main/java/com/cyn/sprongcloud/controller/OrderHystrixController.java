package com.cyn.sprongcloud.controller;

import com.cyn.sprongcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/11/17
 */
@RestController
@Slf4j
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    /**
     * ok
     *
     * @param id
     * @return
     */

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id) {
        String res = paymentHystrixService.paymentInfoOk(id);
        return res;
    }

    /**
     * timeout
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    // @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
        int age = 10 / 0;
        String res = paymentHystrixService.paymentInfoTimeout(id);
        return res;
    }

    /**
     * 超时-降级方法
     *
     * @param id
     * @return
     */
    public String paymentInfoTimeoutHandler(Integer id) {
        return "consumer system busy  paymentInfoTimeoutHandler,id:" + id;
    }

    /**
     * 超时-降级方法-全局
     *
     * @return
     */
    public String paymentInfoTimeoutHandlerGlobal() {
        return "consumer system busy  paymentInfoTimeoutHandlerGlobal";
    }
}
