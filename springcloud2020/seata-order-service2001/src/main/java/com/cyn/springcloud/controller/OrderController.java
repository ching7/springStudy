package com.cyn.springcloud.controller;

import com.cyn.springcloud.domain.Order;
import com.cyn.springcloud.entities.CommonResult;
import com.cyn.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/10
 */
@RestController
public class OrderController {
    @Resource
    OrderService orderService;

    @GetMapping(value = "/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建success");
    }
}
