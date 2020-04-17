package com.cyn.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 文件描述
 *
 * @ProjectName: spring-annotation
 * @Package: com.cyn.config
 * @Date 2020/4/17 15:31
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
@Component
@ConfigurationProperties(prefix = "chenyn.annotation")
public class ConfigurationPropertiesDemo {
    private String test1;
    private Boolean test2 ;

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public Boolean getTest2() {
        return test2;
    }

    public void setTest2(Boolean test2) {
        this.test2 = test2;
    }
}
