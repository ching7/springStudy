//package com.example.springbootes.Config;
//
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.InetSocketTransportAddress;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import java.net.InetAddress;
//
///**
// * @ClassName ElasticSearchConfig
// * @Description
// * @Author ynchen
// * @Date 2023/4/6 11:13
// * @Version V1.0.0
// */
//@Configuration
//public class ElasticSearchConfig {
//
//    @Value("${elasticsearch.host}")
//    private String esHost;
//
//    @Value("${elasticsearch.port}")
//    private int esPort;
//
//    @Value("${elasticsearch.cluster.name}")
//    private String esName;
//
//    @Bean
//    @Primary
//    public TransportClient transportClient() {
//        TransportClient client = null;
//        try {
//            Settings settings = Settings.builder()
//                    .put("cluster.name", this.esName)
//                    .put("client.transport.sniff", true)
//                    .put("client.transport.ignore_cluster_name", true)
//                    .build();
//
//            InetSocketTransportAddress master = new InetSocketTransportAddress(InetAddress.getByName(esHost), esPort);
//
//            client = new PreBuiltTransportClient(settings).
//                    //如果这里
//                            addTransportAddress(master);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return client;
//    }
//}
