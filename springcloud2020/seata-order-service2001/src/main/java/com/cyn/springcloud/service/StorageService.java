package com.cyn.springcloud.service;

import com.cyn.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/10
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    /**
     * 扣库存
     *
     * @param productId
     * @param count
     * @return
     */
    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
