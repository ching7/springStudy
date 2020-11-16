package com.cyn.springcloud.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/11/11
 */
@Log4j2
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    /**
     * zk信息查询
     *
     * @return
     */
    @GetMapping(value = "/payment/consul")
    public String paymentZk() {
        return "springcloud with consul: " + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
