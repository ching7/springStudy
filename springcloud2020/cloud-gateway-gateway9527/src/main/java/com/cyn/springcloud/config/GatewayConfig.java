package com.cyn.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/11/25
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routers = routeLocatorBuilder.routes();
        routers.route("path_route_cyn",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei"))
                .build();
        return routers.build();
    }
}
