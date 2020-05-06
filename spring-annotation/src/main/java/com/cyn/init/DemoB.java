package com.cyn.init;

import org.springframework.stereotype.Component;

/**
 * 文件描述
 *
 * @ProjectName: spring-annotation
 * @Package: com.cyn.init
 * @Date 2020/5/6 19:47
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
@Component
public class DemoB {
    private String name = "Demo B init";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DemoB{" +
                "name='" + name + '\'' +
                '}';
    }
}
