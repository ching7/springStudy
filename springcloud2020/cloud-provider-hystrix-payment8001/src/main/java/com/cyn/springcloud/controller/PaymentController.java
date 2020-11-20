package com.cyn.springcloud.controller;

import com.cyn.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/11/20
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;
    //==============服务降级

    /**
     * ok
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id) {
        String res = paymentService.paymentInfoOk(id);
        log.info("****res:" + res);
        return res;
    }

    /**
     * timeout
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
        String res = paymentService.paymentInfoTimeOut(id);
        log.info("****res:" + res);
        return res;
    }
    //==============服务熔断

    /**
     * 服务熔断
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String res = paymentService.paymentCircuitBreaker(id);
        log.info("****res:" + res);
        return res;
    }
}
