package com.cyn.springcloud.service.impl;

import com.cyn.springcloud.entities.CommonResult;
import com.cyn.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/10
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    StorageService storageService;


    @Override
    public CommonResult decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageService.decrease(productId, count);
        log.info("------->storage-service中扣减库存结束");
        return new CommonResult(200, "扣减库存成功！");
    }
}
