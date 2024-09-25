package service;

import bean.HelloProperties;
import org.springframework.stereotype.Service;
import utils.Circle;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-07-14
 */
public class HelloService {
    HelloProperties helloProperties;


    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String sayHello(String name) {
        return helloProperties.getPrefix() + "-" + name + "-" + helloProperties.getSuffix();
    }

}
