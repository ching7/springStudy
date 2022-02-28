package com.cyn.remote.ext;

import com.cyn.exceptionDown.RemoteHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2022-02-28
 */
@FeignClient(name = "aiccdev",fallback = RemoteHystrix.class)
public interface RemoteClient {
    @GetMapping("/aicc/sysConfig/get/sysInitParam")
    String helloNacos();
}
