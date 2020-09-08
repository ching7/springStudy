package com.cyn.strategypattern.impl;

import com.cyn.strategypattern.Strategy;
import org.springframework.stereotype.Component;

/**
 * 文件描述
 *
 * @ProjectName: springboot-design-pattern
 * @Package: com.cyn.strategypattern.impl
 * @Date 2020/9/8 15:19
 * @Author:
 * @Version: 1.0
 * @Description: note
 **/
@Component("B")
public class ResourceB implements Strategy {

    @Override
    public String getVpcStr(String id) {
        System.out.println("B strategy" + "=====" + id);
        return id;
    }

}