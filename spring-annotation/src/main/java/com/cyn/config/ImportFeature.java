package com.cyn.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 文件描述
 *
 * @ProjectName: spring-annotation
 * @Package: com.cyn.config
 * @Date 2020/4/17 15:54
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class ImportFeature {
    private String var1 = "feature import";
    private Boolean var2 = true;

    @Bean
    @ConfigurationPropertiesBinding
    public WeightConverter weightConverter(){
        return new WeightConverter();
    }

    public String getVar1() {
        return var1;
    }

    public void setVar1(String var1) {
        this.var1 = var1;
    }

    public Boolean getVar2() {
        return var2;
    }

    public void setVar2(Boolean var2) {
        this.var2 = var2;
    }
}
