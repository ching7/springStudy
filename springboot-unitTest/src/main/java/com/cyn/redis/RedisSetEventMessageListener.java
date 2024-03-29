//package com.cyn.redis;
//
//import org.springframework.data.redis.connection.Message;
//import org.springframework.data.redis.listener.RedisMessageListenerContainer;
//import org.springframework.stereotype.Component;
//
///**
// * @author ching
// */
//@Component
//public class RedisSetEventMessageListener extends com.cyn.redis.KeySetEventMessageListener {
//    public RedisSetEventMessageListener(RedisMessageListenerContainer listenerContainer) {
//        super(listenerContainer);
//    }
//
//    /**
//     * 针对redis数据失效事件，进行数据处理
//     *
//     * @param message
//     * @param pattern
//     */
//    @Override
//    public void onMessage(Message message, byte[] pattern) {
//        // 用户做自己的业务处理即可,注意message.toString()可以获取失效的key
//        String expiredKey = message.toString();
//        System.out.println(expiredKey);
//        // redisUtils.delete();
//    }
//}
