package com.cyn.springcloud.controller;

import com.cyn.springcloud.entities.CommonResult;
import com.cyn.springcloud.entities.Payment;
import com.cyn.springcloud.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/11/11
 */
@Log4j2
@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    /**
     * 新增
     *
     * @param payment
     * @return
     */
    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("***insert result:{}", result);
        if (result > 0) {
            return new CommonResult<>(200, "insert success");
        } else {
            return new CommonResult<>(500, "insert error");
        }
    }

    /**
     * id查询
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("***getPaymentById result:{}", paymentById);
        if (paymentById != null) {
            return new CommonResult<>(200, "query success", paymentById);
        } else {
            return new CommonResult<>(500, "query error id:" + id, null);
        }
    }
}
