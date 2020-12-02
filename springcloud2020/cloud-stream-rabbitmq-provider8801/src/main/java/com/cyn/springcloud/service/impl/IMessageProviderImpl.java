package com.cyn.springcloud.service.impl;

import com.cyn.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 消息生产者发送入口
 *
 * @author chenyanan
 * Created by chenyanan on 2020/12/1
 */
@EnableBinding(Source.class)
public class IMessageProviderImpl implements IMessageProvider {
    /**
     * 消息发送通道
     */
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String uuid = UUID.randomUUID().toString();
        // provider: source -> channel -> builder
        // consumer: builder -> channel -> sink
        output.send(MessageBuilder.withPayload(uuid).build());
        System.out.println("********uuid:" + uuid);
        return uuid;
    }
}
