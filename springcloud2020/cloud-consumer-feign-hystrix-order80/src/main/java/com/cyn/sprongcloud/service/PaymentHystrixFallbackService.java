package com.cyn.sprongcloud.service;

import org.springframework.stereotype.Service;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/11/20
 * 对于feign的远程调用，进行全局的服务降级实现
 */
@Service
public class PaymentHystrixFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfoOk(Integer id) {
        return "consumer paymentHystrixFallbackService paymentInfoOk fall";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "consumer paymentHystrixFallbackService paymentInfoTimeout fall";
    }
}

