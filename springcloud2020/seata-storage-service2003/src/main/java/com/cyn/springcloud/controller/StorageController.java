package com.cyn.springcloud.controller;

import com.cyn.springcloud.entities.CommonResult;
import com.cyn.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/10
 */
@RestController
public class StorageController {
    @Resource
    StorageService storageService;

    @PostMapping(value = "/storage/decrease")
    public CommonResult create(@RequestParam("productId") Long productId,@RequestParam("count") Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200, "扣减库存成功！");
    }
}
