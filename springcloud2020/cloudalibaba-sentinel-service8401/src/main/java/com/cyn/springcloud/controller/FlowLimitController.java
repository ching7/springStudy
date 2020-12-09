package com.cyn.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/8
 */
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping(value = "/testA")
    public String testA() throws InterruptedException {
        return "--testA";
    }

    @GetMapping(value = "/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "..testB");
        return "--testB";
    }

    @GetMapping(value = "/testD")
    public String testD() throws InterruptedException {
        Thread.sleep(2000);
        log.info(Thread.currentThread().getName() + "\t" + "..testD");
        return "--testD";
    }

    @GetMapping(value = "/testE")
    public String testE() {
        int a = 10 / 0;
        log.info(Thread.currentThread().getName() + "\t" + "..testE");
        return "--testR";
    }

    @GetMapping(value = "/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "block_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "--testHotKey";
    }

    public String block_testHotKey(String p1, String p2, BlockException blockException) {
        return "--block_testHotKey";
    }
}