package com.cyn;

import com.cyn.core.id.SnowflakeIdGenerator;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @ClassName SnowIdUtils
 * @Description
 * @Author ynchen
 * @Date 2024/3/22 16:41
 * @Version V1.0.0
 */
public class SnowIdUtils {
    private static volatile SnowflakeIdGenerator obj;

    private SnowIdUtils() {

    }

    public static SnowflakeIdGenerator getInstance() {
        if (null == obj) {
            synchronized (SnowIdUtils.class) {
                if (null == obj) {
                    // StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
                    // stringRedisTemplate.setKeySerializer(stringRedisSerializer);
                    // stringRedisTemplate.setValueSerializer(stringRedisSerializer);
                    // stringRedisTemplate.setHashKeySerializer(stringRedisSerializer);
                    // stringRedisTemplate.setHashValueSerializer(stringRedisSerializer);
                    obj = new SnowflakeIdGenerator(1, 1);
                }
            }
        }
        return obj;
    }
}
