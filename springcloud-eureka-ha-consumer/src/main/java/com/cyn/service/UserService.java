package com.cyn.service;

import com.cyn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author chenyn
 * @version 1.0
 * @date 2019/10/27 21:00
 */
@Service
public class UserService {
    /**
     * ribbon负载均衡器
     */
    @Autowired
    private LoadBalancerClient loadBalancerClient ;

    public List<User> getUser(){
        //选择调用的服务的名称
        // serviceInstance 封装了服务的基本信息，如ip，端口
        ServiceInstance si = this.loadBalancerClient.choose("eureka-cyn-provider");
        //拼接访问服务的url --Eureka的方式，dubbo是接口实例
        StringBuffer sb = new StringBuffer();
        // http://localhost:9090/user
        sb.append("http://").append(si.getHost()).append(":").append(si.getPort()).append("/user");
        //springMVC 提供的RestTemplate 发送请求
        RestTemplate rt = new RestTemplate();
        //返回值接收
        ParameterizedTypeReference<List<User>> type = new ParameterizedTypeReference<List<User>>(){};
        //ResponseEntity: 封装了返回信息 rt.exchange :发送请求
        ResponseEntity<List<User>> responseEntity = rt.exchange(sb.toString(), HttpMethod.GET,null,type);
        List<User> list = responseEntity.getBody();
        return list;
    }
}

