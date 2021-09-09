//package com.cyn.redis;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.listener.RedisMessageListenerContainer;
//
///**
// * @Description:
// * @Author: ynchen9
// * @CreateTime: 2021-09-01
// */
//@Configuration
//public class RedisListenerConfig {
//    @Bean
//    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory) {
//
//        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        return container;
//    }
//}