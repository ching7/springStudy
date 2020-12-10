package com.cyn.springcloud.dao;

import com.cyn.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/10
 */
@Mapper
public interface OrderDao {
    /**
     * 新增订单
     *
     * @param order
     */
    void create(Order order);

    /**
     * 更新状态
     *
     * @param userId
     * @param status
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
