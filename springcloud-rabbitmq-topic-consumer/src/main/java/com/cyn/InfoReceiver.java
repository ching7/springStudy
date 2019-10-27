package com.cyn;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 消息接收者
 * @author chenyn
 * @version 1.0
 * @date 2019/10/22 23:12
 *
 * @RabbitListener 队列监听
 *      bindings:绑定队列
 * @QueueBinding 绑定队列的详细配置
 *          value = @Queue:绑定交换器
 *              value:队列的名称
 *              autoDelete:是否是一个可删除的临时队列
 *          exchange = @Exchange:绑定交换器
 *              value:交换器名称
 *              type:交换器类型
 *          key:绑定路由键
 */
@Component
@RabbitListener(
    bindings =@QueueBinding(
        value = @Queue(value = "${mq.config.queue.info}", autoDelete = "true"),
        exchange =@Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.TOPIC),
        key = "*.log.info"
    )
)
public class InfoReceiver {
    /**
     *消息接收方法
     */
    @RabbitHandler
    public void process(String msg){
        System.out.println("Info-------------------receiver:"+msg);
    }
}
