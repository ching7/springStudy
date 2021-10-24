//package com.cyn.redis.listener.cluster;
//
//import io.lettuce.core.cluster.models.partitions.RedisClusterNode;
//import io.lettuce.core.cluster.pubsub.RedisClusterPubSubAdapter;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
///**
// * @Description:
// * @Author: ynchen9
// * @CreateTime: 2021-10-24
// */
//@Component
//public class ClusterGrooveAdapter extends RedisClusterPubSubAdapter {
//
//    private static Logger logger = LoggerFactory.getLogger(ClusterGrooveAdapter.class);
//
//    @Override
//    public void message(RedisClusterNode node, Object channel, Object message) {
//        String expiredKey = null;
//        try {
//            expiredKey = (String) message;
//        } catch (Exception e) {
//            logger.error("错误的过期消息类型");
//            return;
//        }
//        logger.info("过期的key:"+expiredKey);
//        logger.info("处理过期后的业务:");
//    }
//}
