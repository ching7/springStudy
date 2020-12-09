package com.cyn.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cyn.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/9
 */
@Slf4j
@RestController
public class RateLimitController {
    @GetMapping(value = "/byResource")
    @SentinelResource(value = "byResource", blockHandler = "block_byResource")
    public CommonResult byResource() {
        log.info(Thread.currentThread().getName() + "\t" + "..byResource");
        return new CommonResult(200, "--byResource");
    }

    public CommonResult block_byResource(BlockException blockException) {
        return new CommonResult(500, blockException.getClass().getCanonicalName() +
                "--byResource");
    }

    @GetMapping(value = "/byResource/byUrl")
    @SentinelResource(value = "byUrl", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "blockHandlerEx1")
    public CommonResult byResourceUrl() {
        log.info(Thread.currentThread().getName() + "\t" + "..byResourceUrl");
        return new CommonResult(200, "--byResourceUrl");
    }

    @GetMapping(value = "/blockHandler")
    @SentinelResource(value = "blockHandler", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "blockHandlerEx2")
    public CommonResult blockHandler() {
        log.info(Thread.currentThread().getName() + "\t" + "..blockHandler");
        return new CommonResult(200, "--blockHandler");
    }
}
