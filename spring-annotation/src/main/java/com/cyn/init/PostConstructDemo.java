package com.cyn.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 文件描述
 *
 * @ProjectName: spring-annotation
 * @Package: com.cyn.init
 * @Date 2020/5/6 19:46
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
@Component
public class PostConstructDemo {
    public PostConstructDemo() {
        System.out.println("ParentBean construct");
    }

    @Bean
    public DemoA getDemoA() {
        return new DemoA("DemoA init");
    }

    @PostConstruct
    public void init() {
        System.out.println(getDemoA());
        System.out.println("ParentBean init");
    }

}
