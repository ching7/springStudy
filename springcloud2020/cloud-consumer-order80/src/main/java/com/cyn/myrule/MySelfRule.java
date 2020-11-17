package com.cyn.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/11/17
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule() {
        // 负载规则：随机规则
        return new RandomRule();
    }
}
