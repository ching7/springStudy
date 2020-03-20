# springcloud

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

  `Ribbon`保证的就是当前服务使用`RestTemplate`方式调用其他微服务前，使用负载均衡，减少请求峰值

* `Nginx` 和 `Ribbon` 的对比

  * `Nignx` 接收了所有的请求进行负载均衡的，是一种**集中式**的负载均衡器。
  * `Ribbon` 是在消费者端进行的负载均衡

  `Nginx` 使用的是 轮询和加权轮询算法。而在 `Ribbon` 中有更多的负载均衡调度算法，其默认是使用的 `RoundRobinRule` 轮询策略

## 服务容错保护：Hystrix

~~~lua
springcloud
├── eureka-server --服务注册中心
├── hystrix-service --模拟服务容错情况
└── user-service --模拟用户服务
~~~

微服务架构中，服务与服务之间通过远程调用的方式进行通信，一旦某个被调用的服务发生了故障，其依赖服务也会发生故障，此时就会发生故障的蔓延，最终导致系统瘫痪，也被称为`服务雪崩`。

* `Ribbon`是什么 ？能干什么？怎么用？

  * 是什么

    `Hystrix`实现了断路器模式，当某个服务发生故障时，通过断路器的监控，给调用方返回一个错误响应，而不是长时间的等待，这样就不会使得调用方由于长时间得不到响应而占用线程，从而防止故障的蔓延。

  * 能干什么

    `Hystrix`具备服务降级、服务熔断、线程隔离、请求缓存、请求合并及服务监控等强大功能

* `Hystrix`使用注意点

  ~~~java
  @RestController
  @RequestMapping("/userhy")
  public class UserHystrixController {
      @Autowired
      private RestTemplate restTemplate;
      @Value("${service-url.user-service}")
      private String userServiceUrl;
  
      @HystrixCommand(fallbackMethod = "getDefaultUser", 
                      ignoreExceptions = {NullPointerException.class},
                      commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2200")})
      @GetMapping("/testCommand/{id}")
      public String testCommand(@PathVariable Long id) {
          if (id == 1) {
          throw new IndexOutOfBoundsException();
          } else if (id == 2) {
              throw new NullPointerException();
          }
          return restTemplate.getForObject(userServiceUrl + "/user/{1}", String.class, id);
      }
  	/**
       * 服务降级方法
       * @param id
       * @return
       */	
      public String getDefaultUser(@PathVariable Long id) {
          User defaultUser = new User(-1, "defaultUser", "123456");
          return defaultUser.toString();
      }
  }
  ~~~

  * 需要进行容错保护的接口加`@HystrixCommand`注解

    `@HystrixCommand`的常用参数：

    * fallbackMethod：指定服务降级处理方法；
    * ignoreExceptions：忽略某些异常，不发生服务降级。上面的代码，假设用户服务不可用，在发生空指针异常时，会直接抛出异常，在发生其他异常时，会进入降级处理方法
    * commandProperties：服务熔断设置。上面代码设置服务调用超时时间为2200ms，超时自动熔断，进入降级方法

  * `Hystrix`还有线程隔离、请求缓存、请求合并及服务监控等强大功能，这里仅介绍了熔断和降级的常用功能
  

## 基于Ribbon和Hystrix的声明式服务调用：OpenFeign

```lua
springcloud
├── eureka-server --服务注册中心
├── feign-service --声明式服务调用、容错 
└── user-service  --测试用户服务
```

`Feign`是声明式的服务调用工具，我们只需创建一个接口并用注解的方式来配置它，就可以实现对某个服务接口的调用，简化了直接使用RestTemplate来调用服务接口的开发量。

`Feign`具备可插拔的注解支持，同时支持`Feign`注解、JAX-RS注解及SpringMvc注解。当使用`Feign`时，Spring Cloud集成了Ribbon和Eureka以提供负载均衡的服务调用及基于Hystrix的服务容错保护功能。

- 只需要编写远程调用服务的接口，不需要实现。

```java
@FeignClient(value = "user-service")
public interface UserService {
    @PostMapping("/user/create")
    String create(@RequestBody User user);

    @GetMapping("/user/{id}")
    String getUser(@PathVariable Long id);

    @GetMapping("/user/getByUsername")
    String getByUsername(@RequestParam String username);

    @PostMapping("/user/update")
    String update(@RequestBody User user);

    @PostMapping("/user/delete/{id}")
    String delete(@PathVariable Long id);
}
```

`@FeignClient`注解的value值，填写远程调用的服务名称，接口对应远程服务接口

- `Ribbon`负载均衡：如果远程服务有多个，自动默认参数实现负载均衡

```properties
#注意调整超时时间
# feign http远程调用超时时间设置
feign.httpclient.connection-timeout=60000
```

- `Hystrix`容错保护：

```java
// 添加UserFallbackService 实现UserService接口，并且对接口中的每个实现方法进行了服务降级逻辑的实现
// 需要在配置中启用hytrix容错 
// 是否启动用hystrix容错保护
// feign.hystrix.enabled=true
@Component
public class UserFallbackService implements UserService {
    @Override
    public CommonResult create(User user) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(defaultUser);
    }

    @Override
    public CommonResult<User> getUser(Long id) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(defaultUser);
    }

    @Override
    public CommonResult<User> getByUsername(String username) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(defaultUser);
    }

    @Override
    public CommonResult update(User user) {
        return new CommonResult("调用失败，服务被降级",500);
    }

    @Override
    public CommonResult delete(Long id) {
        return new CommonResult("调用失败，服务被降级",500);
    }
}
```

- 在`Feign`中配置`Ribbon`、`Hystrix`可以直接使用其原有的配置

- `Feign`日志服务

  通过java配置来使Feign打印最详细的Http请求日志信息。

```java
// 1
/**
日志级别
NONE：默认的，不显示任何日志；
BASIC：仅记录请求方法、URL、响应状态码及执行时间；
HEADERS：除了BASIC中定义的信息之外，还有请求和响应的头信息；
FULL：除了HEADERS中定义的信息之外，还有请求和响应的正文及元数据。
**/
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}

// 2
// 配置文件新增，指定日志输出的目录
// logging.level.com.cyn.cloud.service=debug

//以上两步配置Feign日志输出
```



## API网关服务：Zuul

~~~lua
springcloud
├── eureka-server --注册中心
├── feign-service --测试feign服务
├── user-service  --测试用户服务
└── zuul-service  --测试zuul服务
~~~

API网关为微服务架构中的服务提供了统一的访问入口，所有客户端的访问都通过它来进行路由及过滤。它实现了请求路由、负载均衡、校验过滤、服务容错、服务聚合等功能。

路由与过滤是Zuul的两大核心功能，路由功能负责将外部请求转发到具体的服务实例上去，是实现统一访问入口的基础，过滤功能负责对请求过程进行额外的处理，是请求校验过滤及服务聚合的基础。

**Zuul路由功能：**

* 注意配置zuul的超时时间

~~~properties
# 调整zuul连接超时时间，否则在debug会出错
zuul.host.connect-timeout-millis=60000
zuul.host.socket-timeout-millis=60000
zuul.host.max-per-route-connections=10000
# zuul路由配置
zuul.routes.user-service.path=/user-service/**
zuul.routes.feign-service.path=/feign-service/**
# 关闭默认路由
zuul.ignored-services=*
~~~

* 配置路由

~~~properties
# 访问http://localhost:8801/user-service/user/1同样可以路由到了user-service上了；

# 访问http://localhost:8801/feign-service/user/1同样可以路由到了feign-service上了。
~~~

* 默认路由关闭

~~~properties
# 假设你的注册服务中心有三个已经注册的服务名称A，B，C
# 但是你在zuul网管服务器中的只隐射了A和B，如下
zuul.routes.a.path=/a/**
zuul.routes.b.path=/b/**
#  因为zuul有默认的隐射机制，如果没有以下的配置，那么访问http://ip:port/c/也可以访问到你的c服务，如果你不想向外界暴露除你配置的隐射之外的服务，可以加上zuul.ignored-services=*
zuul.ignored-services=*

#路由默认过滤设置

#Zuul在请求路由时，默认会过滤掉一些敏感的头信息，以下配置可以防止路由时的Cookie及Authorization的丢失：
#配置过滤敏感的请求头信息，设置为空就不会过滤
zuul.sensitive-headers=Cookie,Set-Cookie,Authorization
#Zuul在请求路由时，不会设置最初的host头信息，以下配置可以解决：
#设置为true重定向是会添加host请求头
zuul.add-host-header=true
~~~

* 查看路由信息

注意依赖pom的添加，以及配置文件开启路由端点

~~~properties
# 开启查看路由的端点
management.endpoints.web.exposure.include='routes'
~~~

**Zuul过滤功能：**

Zuul中有以下几种典型的过滤器类型。

- pre：在请求被路由到目标服务前执行，比如权限校验、打印日志等功能；
- routing：在请求被路由到目标服务时执行，这是使用Apache HttpClient或Netflix Ribbon构建和发送原始HTTP请求的地方；
- post：在请求被路由到目标服务后执行，比如给目标服务的响应添加头信息，收集统计数据等功能；
- error：请求在其他阶段发生错误时执行。

下图描述了一个HTTP请求到达API网关后，如何在各种不同类型的过滤器中流转的过程。

![](../document/image/zuul-filter.jpg)

* 自定义过滤器

注意新增的过滤器是否被框架管理

**注：**由于Zuul自动集成了Ribbon和Hystrix，所以Zuul天生就有负载均衡和服务容错能力，我们可以通过Ribbon和Hystrix的配置来配置Zuul中的相应功能

## 外部集中化配置管理：Config

`Spring Cloud Config `分为服务端和客户端两个部分。服务端被称为分布式配置中心，它是个独立的应用，可以从配置仓库获取配置信息并提供给客户端使用。客户端可以通过配置中心来获取配置信息，在启动时加载配置。

`Spring Cloud Config` 的配置中心默认采用Git来存储配置信息，所以天然就支持配置信息的版本管理，并且可以使用Git客户端来方便地管理和访问配置信息。

`Config-server:`

* 新增config-server模块，调整pom文件，添加`spring-cloud-config-server`、`spring-cloud-starter-netflix-eureka-client`依赖
* 配置`application.properties`、调整启动类增加注解

* 获取配置文件信息的访问格式

  ~~~properties
  # 获取配置信息
  /{label}/{application}-{profile}
  # 获取配置文件信息
  /{label}/{application}-{profile}.properties
  
  # 占位符相关解释
  application：代表应用名称，默认为配置文件中的spring.application.name，如果配置了spring.cloud.config.name，则为该名称；
  label：代表分支名称，对应配置文件中的spring.cloud.config.label；
  profile：代表环境名称，对应配置文件中的spring.cloud.config.profile。
  ~~~

* 访问URL、获取配置

  - 访问http://localhost:8901/master/config-dev来获取master分支上dev环境的配置信息；
  - 访问http://localhost:8901/master/config-dev.properties来获取master分支上dev环境的配置文件信息，对比上面信息，可以看出配置信息和配置文件信息并不是同一个概念；

`Config-client:`

* 新增模块，添加依赖，配置文件修改，新增controller

* 服务启动报错

  可能很不幸，Client服务启不来，提示：**Fetching config from server at: http://localhost:8888**
  其实这是一个配置文件优先级的问题；SpringCloud里面有个“启动上下文”，主要是用于加载远端的配置，也就是加载ConfigServer里面的配置,默认加载顺序为：加载bootstrap.*里面的配置 --> 链接configserver，加载远程配置 --> 加载application.*里面的配置；总结：这里需要借助于“启动上下文”来处理加载远程配置。
  即把`application`改为`bootstrap`即可。

* 获取子目录配置

  ```properties
  ##配置存储配置信息的Git仓库
  spring.cloud.config.server.git.uri=https://github.com/ching7/springcloud-config.git
  spring.cloud.config.server.git.username=ching7spring.cloud.config.server.git.password=123456
  spring.cloud.config.server.git.search-paths=${spring.application.name}
  ```

  注意`spring.application.name`是配置文件仓库的放置配置文件目录，一般和服务名称一样

* 刷新配置

  当Git仓库中的配置信息更改后，而本地服务不重启，我们可以通过`SpringBoot Actuator`的refresh端点来刷新客户端已经缓存的配置信息，以下更改都需要在config-client中进行。

  * 在pom.xml中添加Actuator的依赖：
  * 在bootstrap.properties中开启refresh端点：
  * 在ConfigClientController类添加@RefreshScope注解用于刷新配置

`配置中心添加安全认证：`

`config-server集群：`

参考资料：

> 1.https://juejin.im/post/5de2553e5188256e885f4fa3
>
> 2.http://www.macrozheng.com/#/cloud/ribbon