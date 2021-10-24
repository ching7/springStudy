//package com.cyn.redis.listener.all;
//
//import org.springframework.data.redis.connection.Message;
//import org.springframework.data.redis.connection.MessageListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class RedisExpiredListener implements MessageListener {
//    public final static String LISTENER_PATTERN = "__key*@*__:*";
//
//    @Override
//    public void onMessage(Message message, byte[] bytes) {
//        // 建议使用: valueSerializer
//        String body = new String(message.getBody());
//        String channel = new String(message.getChannel());
//        System.out.println("onMessage >> " + String.format("channel: %s, body: %s, bytes: %s"
//                , channel, body, new String(bytes)));
//
//        if (body.startsWith("product:")) {
//            final String productId = body.replace("product:", "");
//            System.out.println("得到产品id：" + productId);
//        }
//    }
//}