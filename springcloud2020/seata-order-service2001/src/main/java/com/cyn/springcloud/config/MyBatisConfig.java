package com.cyn.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/10
 */
@Configuration
@MapperScan({"com.cyn.springcloud.dao"})
public class MyBatisConfig {
}
