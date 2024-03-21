package com.cyn.core.id;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @ClassName IdAutoConfig
 * @Description
 * @Author ynchen
 * @Date 2024/3/21 17:07
 * @Version V1.0.0
 */
@Configuration
@AutoConfigureAfter({RedisAutoConfiguration.class})
public class IdAutoConfig {
    @Configuration
    @ConditionalOnBean({StringRedisTemplate.class})
    public static class RedisWorkIdConfig {
        @Bean
        public BatchRedisWorkIdService batchRedisWorkIdService() {
            return new BatchRedisWorkIdService();
        }
    }

    @Bean
    public BatchUidService batchUidService() {
        return new BatchUidService();
    }
}
