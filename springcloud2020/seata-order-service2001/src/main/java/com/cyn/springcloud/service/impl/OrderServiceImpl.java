package com.cyn.springcloud.service.impl;

import com.cyn.springcloud.dao.OrderDao;
import com.cyn.springcloud.domain.Order;
import com.cyn.springcloud.service.AccountService;
import com.cyn.springcloud.service.OrderService;
import com.cyn.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/10
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderDao orderDao;

    @Resource
    AccountService accountService;

    @Resource
    StorageService storageService;

    @Override
    @GlobalTransactional(name = "cyn-order-create", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("====开始创建订单");
        orderDao.create(order);
        log.info("====订单服务调用, 库存服务扣减start");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("====订单服务调用, 库存服务扣减end");

        log.info("====订单服务调用, 账户服务扣减start");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("====订单服务调用, 账户服务扣减end");

        log.info("====修改订单状态start");
        orderDao.update(order.getUserId(), 0);
        log.info("====修改订单状态end");

        log.info("All end");
    }
}
