package com.cyn.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author chenyanan
 */
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class RedissonConfig {
    @Value("${spring.redis.cluster.nodes}")
    private String redisNodes;

    @Value("${spring.redis.password}")
    private String redisPwd;
    private static final String REDIS_PREFIX = "redis://";

    @Bean
    public RedissonClient redisson() throws IOException {
        // 1.创建配置
        Config config = new Config();
        // 集群模式
        String[] redisNodeArr = redisNodes.split(",");
        for (int i = 0; i < redisNodeArr.length; i++) {
            redisNodeArr[i] = REDIS_PREFIX + redisNodeArr[i];
        }
        config.useClusterServers().addNodeAddress(redisNodeArr).setPassword(redisPwd);
        return Redisson.create(config);
    }
}
