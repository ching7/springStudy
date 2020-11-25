package com.cyn.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/11/20
 */
@Service
public class PaymentService {

    //==============服务降级

    /**
     * 正常
     *
     * @param id
     * @return
     */
    public String paymentInfoOk(Integer id) {
        return "thread：" + Thread.currentThread().getName() + " paymentInfoOk,id:" + id;
    }

    /**
     * 超时
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfoTimeOut(Integer id) {
        int outTime = 3;
        int age = 10 / 0;
        try {
            TimeUnit.SECONDS.sleep(outTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "thread：" + Thread.currentThread().getName() + " paymentInfoTimeOut,id:" + id + " timeout:" + outTime;
    }

    /**
     * 超时-降级方法
     *
     * @param id
     * @return
     */
    public String paymentInfoTimeoutHandler(Integer id) {
        return " payment system busy paymentInfoTimeOut,id:" + id + " timeoutHandler ";
    }

    //==============服务熔断

    /**
     * 模拟熔断
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerHandler", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),//失败率多少熔断
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("**** id cannot be negative");
        }
        String simpleUUID = IdUtil.simpleUUID();
        return "thread：" + Thread.currentThread().getName() +
                " paymentCircuitBreaker,id:" + id + " simpleUUID:" + simpleUUID;
    }

    /**
     * 超时-降级方法
     *
     * @param id
     * @return
     */
    public String paymentCircuitBreakerHandler(Integer id) {
        return " payment paymentCircuitBreakerHandler,id:" + id + " CircuitBreaker and id cannot be negative ";
    }
}
