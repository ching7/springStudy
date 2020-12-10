package com.cyn.springcloud.service;

import com.cyn.springcloud.domain.Order;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/10
 */
public interface OrderService {
    /**
     * 新增订单
     *
     * @param order
     */
    void create(Order order);
}
