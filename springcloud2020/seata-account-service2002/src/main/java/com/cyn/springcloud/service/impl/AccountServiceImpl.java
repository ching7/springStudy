package com.cyn.springcloud.service.impl;

import com.cyn.springcloud.dao.AccountDao;
import com.cyn.springcloud.entities.CommonResult;
import com.cyn.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/10
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {


    @Resource
    AccountDao accountDao;

    /**
     * 扣减账户余额
     */
    @Override
    public CommonResult decrease(Long userId, BigDecimal money) throws InterruptedException {
        log.info("------->account-service中扣减账户余额开始");
        accountDao.decrease(userId, money);
        // Thread.sleep(20000);
        log.info("------->account-service中扣减账户余额结束");
        return new CommonResult(200, "账户余额成功！");
    }
}
