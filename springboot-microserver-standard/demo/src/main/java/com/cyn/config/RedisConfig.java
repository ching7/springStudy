package com.cyn.config;

/**
 * @ClassName RedisConfig
 * @Description
 * @Author ynchen
 * @Date 2024/3/21 17:53
 * @Version V1.0.0
 */

import java.io.IOException;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.data.redis.config.ConfigureRedisAction;


/**
 * session存入redis配置类
 */
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class RedisConfig {

    @Value("${session.timeout.seconds:1800}")
    private int sessionTimeoutSeconds;

    @Value("${spring.redis.cluster.nodes:}")
    private String redisNodes;

    @Value("${spring.redis.password:}")
    private String redisPwd;

    private static final String REDIS_PREFIX = "redis://";

    public static RedisSerializer<String> KEY_SERIALIZER = new StringRedisSerializer();
    public static RedisSerializer<Object> VALUE_SERIALIZER = new GenericFastJsonRedisSerializer();

    public static GenericToStringSerializer ID_VALUE_SERIALIZER = new GenericToStringSerializer(Object.class);

    @Bean
    public static ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }


    /**
     * spring session redis 序列化
     */
    @Bean
    public RedisSerializer<Object> springSessionDefaultRedisSerializer() {
        return VALUE_SERIALIZER;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();

        stringRedisTemplate.setConnectionFactory(redisConnectionFactory);
        stringRedisTemplate.setKeySerializer(KEY_SERIALIZER);
        stringRedisTemplate.setValueSerializer(VALUE_SERIALIZER);

        stringRedisTemplate.setHashKeySerializer(KEY_SERIALIZER);
        stringRedisTemplate.setHashValueSerializer(VALUE_SERIALIZER);

        return stringRedisTemplate;
    }

    @Bean
    public RedisTemplate<Object, Object> getRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        redisTemplate.setKeySerializer(KEY_SERIALIZER);
        redisTemplate.setValueSerializer(VALUE_SERIALIZER);

        redisTemplate.setHashKeySerializer(KEY_SERIALIZER);
        redisTemplate.setHashValueSerializer(VALUE_SERIALIZER);

        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
    @Bean
    public RedissonClient redisson() {
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