//package com.cyn.redis.listener.cluster;
//
//import io.lettuce.core.cluster.RedisClusterClient;
//import io.lettuce.core.cluster.pubsub.StatefulRedisClusterPubSubConnection;
//import io.lettuce.core.cluster.pubsub.api.async.NodeSelectionPubSubAsyncCommands;
//import io.lettuce.core.cluster.pubsub.api.async.PubSubAsyncNodeSelection;
//import io.lettuce.core.pubsub.RedisPubSubAdapter;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//
///**
// * @Description:
// * @Author: ynchen9
// * @CreateTime: 2021-10-24
// */
//@Component
//public class LettuceSubscriber extends RedisPubSubAdapter {
//
//    private static Logger logger = LoggerFactory.getLogger(LettuceSubscriber.class);
//
//    private static final String EXPIRED_CHANNEL = "__key*@*__:*";
//
//
//    @Resource
//    RedisClusterClient clusterClient;
//
//    @Autowired
//    private ClusterGrooveAdapter clusterGrooveAdapter;
//
//
//    /**
//     * 启动监听
//     */
//    public void startListener() {
//        // 异步订阅
//        StatefulRedisClusterPubSubConnection<String, String> pubSubConnection = clusterClient.connectPubSub();
//        pubSubConnection.setNodeMessagePropagation(true);
//        pubSubConnection.addListener(clusterGrooveAdapter);
//
//        PubSubAsyncNodeSelection<String, String> masters = pubSubConnection.async().masters();
//        NodeSelectionPubSubAsyncCommands<String, String> commands = masters.commands();
//        commands.subscribe(EXPIRED_CHANNEL);
//    }
//}
