package com.cyn.controller;

import com.cyn.OrderSender;
import com.cyn.ProductSender;
import com.cyn.UserSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-08-09
 */
@RestController
public class SenderController {
    @Autowired
    private UserSender userSender;
    @Autowired
    private ProductSender productSender;
    @Autowired
    private OrderSender orderSender;

    @RequestMapping("/sendMsg")
    public void sendMsg() {
        this.userSender.send("UserSender.......");
//        this.productSender.send("ProductSender.......");
//        this.orderSender.send("OrderSender.......");
    }
}
