# springcloud-eureka

服务注册与发现组件

~~~lua
springcloud-eureka
├── eureka-client --注册服务
├── eureka-server --服务注册中心
└── src
~~~

* idea启动springboot使用同的配置文件

~~~properties
program argument : --spring.profiles.active=XXX
多文件的时候配置文件前面的application不用写

例如：配置文件共2个
application-eureka1.properties
application-eureka2.properties

启动时：
program argument : --spring.profiles.active=eureka1 使用配置文件1启动
program argument : --spring.profiles.active=eureka2 使用配置文件2启动
~~~

* 给Eureka注册中心添加认证

~~~properties
我们需要登录即可访问到Eureka服务，这样其实是不安全的,需要为为Eureka添加用户认证。给Eureka注册中心添加认证

#注册到有登录认证的注册中心
eureka.client.service-url.defaultZone=http://cyn:123456@eureka1:8004/eureka/
~~~

