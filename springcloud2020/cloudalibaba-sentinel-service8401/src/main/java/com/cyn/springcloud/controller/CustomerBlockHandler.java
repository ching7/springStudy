package com.cyn.springcloud.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cyn.springcloud.entities.CommonResult;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/9
 */
public class CustomerBlockHandler {
    public static CommonResult blockHandlerEx1(BlockException blockException) {
        return new CommonResult(5001, blockException.getClass().getCanonicalName() +
                "--blockHandlerEx1");
    }

    public static CommonResult blockHandlerEx2(BlockException blockException) {
        return new CommonResult(5002, blockException.getClass().getCanonicalName() +
                "--blockHandlerEx2");
    }
}
