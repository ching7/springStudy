# Spring学习日记



## 2019-08-29 动态代理

> 为了解决静态代理频繁编写代理方法的缺点

1. ***JDK***提供的动态代理

   ~~~html
   优点：jdk自带，无需导入jar
   缺点：真是对象必须实现接口 利用java反射机制效率不高
   ~~~

   

2. ***cglib***动态代理

## 2019-08-28 注解配置aop

*  ***spring***的注解不会自动加载

  1. 需要配置扫描的包，哪些包存在spring注解

     ~~~java
     <context:component-scan base-package="com.cyn.advice"></context:component-scan>
     ~~~

  2. 常用注解

     ~~~java
     @component
     相当于<bean id="类名小写" class="类所在位置"/>
     
     @Aspect
     <aop:aspect ref="类名小写"></aop:aspect>
     
     @Pointcut("execution(* com.cyn.test.Demo123.demo1())")
     相当于 <aop:pointcut id="myPoint3" expression="execution(* com.cyn.test.Demo123.demo1())"/>
     
     @Before("com.cyn.test.Demo123.demo1()")
     相当于<aop:before method="before" pointcut-ref="myPoint3" />
         
     @After,@AfterThrowing,@Around类似
     
     参考对比：无注解写法
      <!--aspectJ普通通知的写法-->
         <bean id="myAfterAdviceAspectJ" class="com.cyn.advice.MyAfterAdviceAspectJ"></bean>
         <aop:config>
             <aop:aspect ref="myAfterAdviceAspectJ">
                 <!--aspectJ通知 获取切点参数-->
                 <aop:pointcut id="myPoint5" expression="execution( * com.cyn.test.Demo1.Demo14(String,int)) and args(name1,age1))"/>
                <!-- <aop:after method="after" pointcut-ref="myPoint5" />-->
                 <aop:before method="before" pointcut-ref="myPoint5" arg-names="name1,age1" />
             </aop:aspect>
         </aop:config>
       
     ~~~

## 2019-08-27  更新aop异常通知\环绕通知  

> aop的异常通知的schema-base实现

> 环绕通知：把前置、后置通知写在一个通知中

> ***aop***通知的***AspectJ***写法

## 2019-08-27  新增markdown语法记录日志

- 添加***spring***基础运行环境

  ```java
  spring01-runtime
  ```

  

- 添加***java***图形验证码

  ```java
  validCode
  ```

- 支持***spring***对接***mybatis***

  ```java
  spring02-mybatis
  ```

  

- 添加***springAop***

- ***springIoc***的demo、***springAop-aspect***的demo

  ```java
  spring03-aop
  ```
