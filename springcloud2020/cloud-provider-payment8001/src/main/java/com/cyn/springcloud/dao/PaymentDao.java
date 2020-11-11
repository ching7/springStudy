package com.cyn.springcloud.dao;

import com.cyn.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/11/11
 */
@Mapper
public interface PaymentDao {
    /**
     * 新增
     *
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * id查询
     *
     * @param id
     * @return
     */
    Payment getPaymentById(@Param("id") Long id);

}
