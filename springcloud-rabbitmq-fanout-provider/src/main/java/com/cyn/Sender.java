package com.cyn;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 消息发送者
 * @author chenyn
 * @version 1.0
 * @date 2019/10/22 23:29
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitAmqbTemplate;

    /**
     * 交换器名称
     */
    @Value("${mq.config.exchange}")
    private String exchange;

    /**
     * routingKey路由键
     */

    /**
     * 消息发送方法
     */
    public void send(String msg){
        //向消息队列发送消息
        //参数一：交换器名称
        //参数二：路由键
        //参数三：消息
        this.rabbitAmqbTemplate.convertAndSend(this.exchange,"","fanout......."+msg);
    }
}
