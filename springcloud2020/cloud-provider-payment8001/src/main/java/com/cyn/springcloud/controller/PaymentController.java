package com.cyn.springcloud.controller;

import com.cyn.springcloud.entities.CommonResult;
import com.cyn.springcloud.entities.Payment;
import com.cyn.springcloud.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/11/11
 */
@Log4j2
@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    /**
     * 注意导入的包是springcloud的不是netflix
     */
    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 新增
     *
     * @param payment
     * @return
     */
    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*** {} ,insert result:{}", serverPort, result);
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
        log.info("*** {} ,getPaymentById result:{}", serverPort, paymentById);
        if (paymentById != null) {
            return new CommonResult<>(200, "query success:" + paymentById + ":" + serverPort);
        } else {
            return new CommonResult<>(500, "query error id:" + id, null);
        }
    }

    /**
     * 服务节点信息获取
     *
     * @return
     */
    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        // 所有服务
        services.forEach(service -> {
            log.info("****service:{}", service);
        });
        // 单个服务对应的实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(instance -> {
            log.info(instance.getServiceId() + "/" + instance.getHost() + "/" + instance.getPort() + "/" + instance.getUri());
        });
        return this.discoveryClient;
    }

    /**
     * 负载测试
     *
     * @return
     */
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    /**
     * 模拟远程超时调用
     *
     * @return
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        // 线程暂停
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    /**
     * zipkin 链路模拟调用
     *
     * @return
     */
    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "hi ,i'am payment zipkin server fall back，serverPort: " + serverPort + ",UUID:" + UUID.randomUUID().toString();
    }
}
