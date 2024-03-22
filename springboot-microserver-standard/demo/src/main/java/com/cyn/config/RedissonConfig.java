package com.cyn.config;

import cn.hutool.core.util.StrUtil;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

    @Value("${spring.redis.cluster.nodes:}")
    private String nodes;

    @Value("${spring.redis.host:}")
    private String host;

    @Value("${spring.redis.port:}")
    private String port;

    @Value("${spring.redis.password:}")
    private String password;

    @Bean
    public RedissonClient redissonClient() throws Exception {
        if (!StrUtil.isBlank(port)) {
            return single();
        }
        return cluster();
    }

    private RedissonClient cluster() throws Exception {
        Config config = new Config();
        if (StrUtil.isBlank(nodes)) {
            throw new Exception("spring.redis.cluster.nodes is null, please check...");
        }
        ClusterServersConfig cfg = config.useClusterServers();
        String[] split = nodes.split(",");
        for (String node : split) {
            cfg.addNodeAddress("redis://" + node);
        }
//		ClusterServersConfig cfg = config.useClusterServers().addNodeAddress(StringUtils.join(paramNodes, ","));
        if (StrUtil.isNotBlank(password)) {
            cfg.setPassword(password);
        }
        return Redisson.create(config);
    }

    private RedissonClient single() {
        if (StrUtil.isBlank(port)) {
            return null;
        }
        Config config = new Config();
        String redisUrl = String.format("redis://%s:%s", host, port);
        config.useSingleServer().setAddress(redisUrl);
        if (StrUtil.isNotBlank(password)) {
            config.useSingleServer().setPassword(password);
        }
        return Redisson.create(config);
    }
}
