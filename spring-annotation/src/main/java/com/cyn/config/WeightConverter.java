package com.cyn.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

/**
 * 文件描述
 *
 * @ProjectName: spring-annotation
 * @Package: com.cyn.config
 * @Date 2020/4/17 16:51
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
@Configuration
public class WeightConverter implements Converter<String,Weight> {

    @Override
    public Weight convert(String s) {
        Weight weight = new Weight();
        weight.var1 = s+"cyn";
        return weight;
    }
}
