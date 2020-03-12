# springStudy

[![java](https://img.shields.io/badge/JAVA-1.8+-green.svg)](#springcloud-eureka)  [![springBoot](https://img.shields.io/badge/apache-springboot-green.svg)](#springcloud-rabbmitmq)

spring基础知识学习

~~~lua
springStudy
├── spring-aop --spring基础特性：切面编程
├── spring-DI --spring基础特性：依赖注入
├── springboot-exception --springboot基础：异常处理
├── springboot-mybatis --springboot整合mybatis
├── springboot-servlet --springboot整合servlet **重要
├── springboot-unitTest --springboot基础：单元测试
├── springboot-validate --springboot基础：出入参合法性
├── springboot-view-freemarker --springboot整合视图层技术freemarker
├── springboot-view-jsp --springboot整合视图层技术jsp
├── springcloud-eureka --springcloud组件eureka注册中心，服务注册发现
├── springcloud-eureka-ha --注册中心
├── springcloud-eureka-ha-consumer --服务生产者
├── springcloud-eureka-ha-provider --服务消费者
├── springcloud-rabbitmq-direct-consumer --springcloud组件rabbitmq消息队列
├── springcloud-rabbitmq-direct-provider
├── springcloud-rabbitmq-fanout-consumer
├── springcloud-rabbitmq-fanout-provider
├── springcloud-rabbitmq-topic-consumer
├── springcloud-rabbitmq-topic-provider
├── springcloud-rabbmitmq
├── springmvc-base --springmvc基础各类解析器，常用注解
├── springmvc-mybatis --springmvc整合mybatis
~~~



## spring-DI

* spring特性DI、依赖注入
* 通过BeanFactory注入实现基础实现demo

## spring-aop

* spring特性AOP、面写切面、
* 面写切面的基础demo，前置、后置、环绕通知demo

## springmvc-base

- springmvc配置文件配置，注解驱动、静态资源映射、视图解析器、文件上传解析器、异常处理解析器
- springmvc常用注解RequestMapping、ResponseBody、RequestParam
- Request请求跳转到视图层jsp的demo
- springmvc进行文件上传下载的demo

## springmvc-mybatis

- spring整合mybatis的demo
  - springmvc基础逻辑demo
  - springmvc的mybatis的整合配置，mybatis的mysql配置
  - mybatis的注解形式sql
  - 简单的账号密码查询登陆，jsp跳转

## springboot-servlet

- springboot整合基础servlet技术基础demo
- springboot整合特殊的servlet技术filter、listener基础demo
- springboot的controller进行文件上传的demo
- springboot的启动的注册serlvet的demo

## springboot-unTest

- springboot如何进行单元测试整合junit4

## springboot-exception 

* springboot处理请求时的异常处理demo

## springboot-validate

* springboot注解校验Bean数据合法性
  * @Valid、@ModelAttribute

* 校验异常，视图跳转@PathVariable

## springboot-view

* springboot整合freemarker视图层技术demo
* springboot整合freemarker视图层技术jsp

## springcloud-eureka

* springcloud-eureka 注册中心demo
* springcloud-eureka-ha 分布式注册中心demo
* springcloud-eureka-ha-provider、springcloud-eureka-ha-consumer消费者提供者注册，以及调用代码基础demo

## springcloud-rabbmitmq

* springcloud-rabbmitmq 消息队列基础，创建队列，发送与接受消息
* springcloud-rabbmitmq-direct 消息交换模式
* springcloud-rabbmitmq-fanout 消息交换模式
* springcloud-rabbitmq-topic 消息交换模式
