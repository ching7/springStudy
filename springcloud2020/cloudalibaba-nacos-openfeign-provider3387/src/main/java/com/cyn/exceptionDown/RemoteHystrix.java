package com.cyn.exceptionDown;

import com.cyn.remote.ext.RemoteClient;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2022-02-28
 */
@Component
public class RemoteHystrix implements RemoteClient {
    @Override
    public String helloNacos() {
        return "请求超时了";
    }
}
