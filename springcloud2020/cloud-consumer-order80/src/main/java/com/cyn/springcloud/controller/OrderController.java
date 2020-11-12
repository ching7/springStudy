package com.cyn.springcloud.controller;

import com.cyn.springcloud.entities.CommonResult;
import com.cyn.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/11/11
 */
@RestController
public class OrderController {

    public static final String PAYMENT_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    /**
     * 消费者新增
     *
     * @param payment
     * @return
     */
    @GetMapping(value = "/consumer/payment/create")
    public CommonResult create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    /**
     * 消费者查询
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
}
