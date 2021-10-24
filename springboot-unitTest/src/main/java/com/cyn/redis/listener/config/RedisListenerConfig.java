package com.cyn.redis.listener.config;

//import com.cyn.redis.listener.all.RedisExpiredListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-09-01
 */
@Configuration
public class RedisListenerConfig {
    public final static String LISTENER_PATTERN = "__key*@*__:*";

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        // 设置监听的Topic: PatternTopic/ChannelTopic
        //Topic topic = new PatternTopic(LISTENER_PATTERN);
        //设置监听器
       // container.addMessageListener(new RedisExpiredListener(), topic);
        return container;
    }
}