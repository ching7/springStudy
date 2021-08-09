package com.cyn.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-08-09
 * <p>
 * SpringBoot中事件监听机制则通过发布-订阅实现，主要包括以下三部分：
 * <p>
 * 事件 ApplicationEvent，继承JDK的EventObject，可自定义事件。
 * 事件发布者 ApplicationEventPublisher，负责事件发布。
 * 事件监听者 ApplicationListener，继承JDK的EventListener，负责监听指定的事件。
 */
public class Eventlistent extends ApplicationEvent {
    private String uname;

    public Eventlistent(Object source) {
        super(source);
    }

    public Eventlistent(Object source, String username) {
        super(source);
        this.uname = username;
    }

    public String getUsername() {
        return uname;
    }
}
