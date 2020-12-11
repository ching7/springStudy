package com.cyn.springcloud.controller;


import com.cyn.springcloud.entities.CommonResult;
import com.cyn.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/10
 */
@RestController
public class AccountController {
    @Resource
    AccountService accountService;

    @PostMapping("/account/decrease")
    public CommonResult create(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) throws InterruptedException {
        accountService.decrease(userId, money);
        return new CommonResult(200, "减扣余额成功 success");
    }
}
