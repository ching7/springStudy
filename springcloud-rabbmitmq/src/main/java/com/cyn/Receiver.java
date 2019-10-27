package com.cyn;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息接收者
 * @author chenyn
 * @version 1.0
 * @date 2019/10/22 0:07
 */
@Component
public class Receiver {
    /**
     * 接收消息的方法
     * 采用监听消息队列机制
      */
    @RabbitListener(queues = "Hello-Queue")
    public void process(String msg){
        System.out.println("receiver: "+msg);
    }
}
