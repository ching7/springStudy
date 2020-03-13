# springcloud

`springcloud`：

Spring Cloud 为最常见的分布式系统模式提供了一种简单且易于接受的编程模型，帮助开发人员构建有弹性的、可靠的、协调的应用程序。Spring Cloud 构建于 Spring Boot 之上，使得开发者很容易入手并快速应用于生产中。

Spring Cloud为开发人员提供了快速构建分布式系统架构的工具，例如配置管理，服务发现，断路器，智能路由，微代理，控制总线，一次性令牌，全局锁定，领导选举，分布式会话，集群状态等。

![springcloud架构图](../document/image/springcloud01.jpg)

## **服务注册与发现组件：`Eureka`**

~~~lua
springcloud
├── eureka-client --注册服务
├── eureka-server --服务注册中心
└── eureka-security-server --服务注册中心添加简单认证
~~~

* `Eureka`是什么 ？能干什么？怎么用？

  * 是什么

  在微服务架构中往往会有一个注册中心，每个微服务都会向注册中心去注册自己的地址及端口信息，注册中心维护着服务名称与服务实例的对应关系。

  * 能干什么：

  每个微服务都会定时从注册中心获取服务列表，同时汇报自己的运行情况，这样当有的服务需要调用其他服务时，就可以从自己获取到的服务列表中获取实例地址进行调用，Eureka实现了这套服务注册与发现机制。

* `Eureka`使用demo注意点

~~~properties
1、idea启动springboot使用不同的配置文件
program argument : --spring.profiles.active=XXX
多文件的时候配置文件前面的application不用写

例如：配置文件共2个
application-eureka1.properties
application-eureka2.properties

启动时：
program argument : --spring.profiles.active=eureka1 使用配置文件1启动
program argument : --spring.profiles.active=eureka2 使用配置文件2启动

2、给Eureka注册中心添加认证
我们需要登录即可访问到Eureka服务，这样其实是不安全的,需要为为Eureka添加用户认证。给Eureka注册中心添加认证
#注册到有登录认证的注册中心
eureka.client.service-url.defaultZone=http://cyn:123456@eureka1:8004/eureka/
~~~

* `Eureka`深入

  可以充当服务发现的组件有很多：`Zookeeper` ，`Consul` ， `Eureka` 等。

  * `Eureka` 与 `Zookeeper` 对比

    Eureka： **符合AP原则** 为了保证了可用性，`Eureka` 不会等待集群所有节点都已同步信息完成，它会无时无刻提供服务。

    Zookeeper： **符合CP原则** 为了保证一致性，在所有节点同步完成之前是阻塞状态的。

[深入理解Eureka](https://juejin.im/post/593cc4c25c497d006b876429)

## **负载均衡的服务调用：`Ribbon`**

~~~lua
springcloud
├── eureka-server --服务注册中心
├── ribbon-service --负载均衡的服务调用
└── user-service --模拟用户操作服务
~~~

* 微服务间的调用策略

微服务之间的调用是使用的 `RestTemplate`，`RestTemplate`是`Spring`提供的一个访问Http服务的客户端类

[深入了解RestTemplate](https://my.oschina.net/sdlvzg/blog/1800395)

* `Ribbon`是什么 ？能干什么？怎么用？

  * 是什么：

  `Ribbon` 是 `Netflix` 公司的一个开源的负载均衡 项目，是一个客户端/进程内负载均衡器，**运行在消费者端**

  * 能干什么：

  通常情况下，为了保持微服务的高可用，一个微服务往往会部署在多台机器上。以秒杀服务为例，如果同一时间秒杀服务收到收到大量调用请求，如果没有负载均衡，可能所有的请求都会到同一台机器上，导致系统响应缓慢，且之前做的集群就没有了作用。

  这时候需要一个均衡器，在进行服务调用时，进行负载均衡算法，对微服务集群进行调用，避免大量请求集中到一台机器上。

* `Nginx` 和 `Ribbon` 的对比

  * `Nignx` 接收了所有的请求进行负载均衡的，是一种**集中式**的负载均衡器。
  * `Ribbon` 是在消费者端进行的负载均衡

  `Nginx` 使用的是 轮询和加权轮询算法。而在 `Ribbon` 中有更多的负载均衡调度算法，其默认是使用的 `RoundRobinRule` 轮询策略

> 参考资料：
>
> 1.https://juejin.im/post/5de2553e5188256e885f4fa3
>
> 2.http://www.macrozheng.com/#/cloud/ribbon