//package com.cyn.redis.listener.cluster;
//
//import io.lettuce.core.RedisURI;
//import io.lettuce.core.cluster.RedisClusterClient;
//import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
//import io.lettuce.core.resource.ClientResources;
//import io.lettuce.core.resource.DefaultClientResources;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @Description:
// * @Author: ynchen9
// * @CreateTime: 2021-10-24
// */
//@Configuration
//public class LettuceConfig {
//
//    @Value("${spring.redis.cluster.nodes}")
//    private String clusterNodes;
//
//    @Value("${spring.redis.password}")
//    private String password;
//
//    @Bean(destroyMethod = "shutdown")
//    ClientResources clientResources() {
//        return DefaultClientResources.create();
//    }
//
//    @Bean(destroyMethod = "shutdown")
//    RedisClusterClient redisClusterClient(ClientResources clientResources) {
//
//        //redis集群监听
//        String[] redisNodes = clusterNodes.split(",");
//        //监听其中一个端口号即可
//        RedisURI redisURI = RedisURI.create("redis://" + redisNodes[0]);
//        redisURI.setPassword(password);
//        return RedisClusterClient.create(clientResources, redisURI);
//    }
//
//    @Bean(destroyMethod = "close")
//    StatefulRedisClusterConnection statefulRedisClusterConnection(RedisClusterClient redisClusterClient) {
//        return redisClusterClient.connect();
//    }
//}
