package com.cyn.springcloud.service;

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
        return  " payment system busy paymentInfoTimeOut,id:" + id + " timeoutHandler ";
    }
}
