package com.cyn.redis;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-09-01
 */
@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {
    private static RedisUtils redisUtils;

    static {
        try {
            redisUtils = RedisUtils.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    /**
     * 针对redis数据失效事件，进行数据处理
     *
     * @param message
     * @param pattern
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 用户做自己的业务处理即可,注意message.toString()可以获取失效的key
        String expiredKey = message.toString();
        Object o = redisUtils.keys(expiredKey + "_2*");
        System.out.println(expiredKey);
        System.out.println(o);
        // redisUtils.delete();
    }
}
