package com.cyn.cloud.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 文件描述
 *
 * @ProjectName: springcloud-eureka
 * @Package: com.cyn.cloud.config
 * @Date 2020/3/12 17:00
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/eureka/**");
        super.configure(http);
    }
}
