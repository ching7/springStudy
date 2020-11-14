package com.cyn.springcloud.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping(value = "/payment/zk")
    public String paymentZk() {
        return "springcloud with zookeeper: " + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
