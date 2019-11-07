# 一、SpringDemo

---

## 1、java-reflect

* 提供java反射，反射获取注解的基础demo

## 2、spring01-runtime

* spring基础允许环境搭建的demo

## 3、spring02-mybatis

* spring整合mybatis的demo

## 4、spring03-aop

* spring特性AOP的原理，切面demo，通知demo

## 5、spring04-proxy

spring中涉及的代理模式

- 什么是代理设计模式
  1. 真实对象（总裁）
  2. 代理对象（秘书）
  3. 抽象对象或抽象功能（谈合作）
- 代理设计模式优点
  1. 保护真实对象
  2. 让真实对象功能更明确
  3. 增强拓展性
- *静态代理* 设计模式（由代理对象代理真实对象的所有功能）
  1. 自己编写代理类
  2. 每个代理的功能需要单独编写(静态代理不足点)

> 为了解决静态代理频繁编写代理方法的缺点

1. ***JDK***提供的动态代理

   ```
   - 优点
   	- jdk自带，无需导入jar
   - 缺点
   	- 真是对象必须实现接口 利用java反射机制效率不高
   ```

2. ***cglib***动态代理

   ~~~java
   - 优点
     - 基于字节码文件，生成真实代理对象的子类
     - 运行效率高于JDK动态代理
     - 不需要实现接口
   - 缺点
     - 需要导入jar
   ~~~

## 6、springboot-admin | springboot-client | springboot-exception | springboot-fastbuild

* 搭建基础的springboot运行demo，模拟微服务admin\client
* springboot的异常处理demo
* 在spring.io官网快速构建springboot项目

## 7、springboot-mybatis | springboot-unTest | springboot-validate

* springboot整合mybatis的demo
* springboot服务端校验数据demo
* springboot单元测试demo

## 8、springboot-view-freemarker | springboot-view-jsp

* springboot整合freemarker视图层技术demo
* springboot整合freemarker视图层技术jsp

## 9、springboot

* springboot 整合MVC开发基础web页面demo

## 10、springcloud-eureka | springcloud-rabbmitmq

* springcloud整合eureka注册中心，分布式eureka注册中demo
* springcloud整合rabbmitmq的demo

## 11、springmvc

* 提供springMVC下的文件上传下载demo

## 12、validCode

* spring结合mybatis 实现登录
* 添加验证码生成模块