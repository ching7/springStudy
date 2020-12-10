package com.cyn.springcloud.service;

import com.cyn.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/10
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {
    /**
     * 扣余额
     *
     * @param productId
     * @param money
     * @return
     */
    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long productId, @RequestParam("money") BigDecimal money);

}
