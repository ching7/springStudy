package com.cyn.springcloud.service.impl;

import com.cyn.springcloud.dao.PaymentDao;
import com.cyn.springcloud.entities.Payment;
import com.cyn.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/11/11
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
