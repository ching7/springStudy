package com.cyn.core.id;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;

import com.cyn.core.util.InetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.util.StringUtils;

/**
 * @author chenyanan
 */
public class BatchRedisWorkIdService {
    public static final long TIMEOUT_DAY = 365L;

    @Value("${coreboot.batchid.startWorkerId:100}")
    private Integer startWorkerId;

    @Value("${coreboot.batchid.workerIdSize:100}")
    private Integer workerIdSize;

    @Value("${coreboot.batchid.prefix:${spring.application.name:default}}:ID:AUTOINCREASE")
    private String autoIncreaseKey;

    @Value("${coreboot.batchid.prefix:${spring.application.name:default}}:ID:WORKID")
    private String workIdKeyPrefix;

    @Value("${spring.cloud.client.ip-address:${spring.cloud.client.ipAddress:}}")
    private String host;

    @Value("${server.port:8080}")
    private String port;

    private String workerIdKey;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostConstruct
    public void postConstruct() {
        if (StringUtils.isEmpty(this.host)) {
            this.host = Objects.requireNonNull(InetUtils.findFirstNonLoopbackAddress()).getHostAddress();
        }
        this.workerIdKey = this.workIdKeyPrefix + ":" + this.host + "_" + this.port;
    }

    public Integer getWorkId() {
        String val = this.redisTemplate.opsForValue().get(this.workerIdKey);
        if (StringUtils.isEmpty(val)) {
            val = String.valueOf(this.startWorkerId + (increment() - this.startWorkerId) % this.workerIdSize);
            this.redisTemplate.opsForValue().set(this.workerIdKey, val, 7L, TimeUnit.DAYS);
        }
        return Integer.parseInt(val);
    }

    private long increment() {
        RedisSerializer<?> oldRedisSerializer = this.redisTemplate.getValueSerializer();
        this.redisTemplate.setValueSerializer(new GenericToStringSerializer<>(Object.class));
        if (Boolean.FALSE.equals(this.redisTemplate.hasKey(this.autoIncreaseKey))) {
            this.redisTemplate.opsForValue().set(this.autoIncreaseKey, String.valueOf(this.startWorkerId - 1), TIMEOUT_DAY, TimeUnit.DAYS);
        }
        long val = this.redisTemplate.opsForValue().increment(this.autoIncreaseKey, 1L);
        this.redisTemplate.expire(this.autoIncreaseKey, 365L, TimeUnit.DAYS);
        this.redisTemplate.setValueSerializer(oldRedisSerializer);
        return val;
    }
}
