# Spring学习日记

---

## 2019-10-10 SpringBoot学习-整合持久层技术（mybatis）

### 1.整合mybatis-项目初始化

* 1.修改pom

  ~~~xml
  <!--继承spring-boot 父工程-->
      <parent>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-parent</artifactId>
          <version>2.1.6.RELEASE</version>
      </parent> 
  	<dependencies>
          <!--springboot web 启动器-->
          <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-web</artifactId>
          </dependency>
          <!--springboot thymeleaf启动-->
          <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-thymeleaf</artifactId>
          </dependency>
          <!--springboot mybatis 启动器-->
          <dependency>
              <groupId>org.mybatis.spring.boot</groupId>
              <artifactId>mybatis-spring-boot-starter</artifactId>
              <version>2.0.0-SNAPSHOT</version>
          </dependency>
          <!--mysql数据库驱动-->
          <dependency>
              <groupId>mysql</groupId>
              <artifactId>mysql-connector-java</artifactId>
          </dependency>
          <!--druid 数据库连接池-->
          <dependency>
              <groupId>com.alibaba</groupId>
              <artifactId>druid</artifactId>
              <version>1.1.12</version>
          </dependency>
      </dependencies>
  ~~~

* 2.配置aplication.properties src/main/resources/properties

  ~~~properties
  # springboot 整合mybatis配置
  spring.datasource.driver-class-name=com.mysql.jdbc.Driver
  spring.datasource.url=jdbc:mysql://local:3306/springboot
  spring.datasource.username=root
  spring.datasource.password=root
  
  # druid数据库连接池配置
  spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
  
  # mybatis 实体类包 别名
  mybatis.type-aliases-package=com.cyn.bean
  ~~~

* 3.数据库表设计

  ~~~sql
  -- 创建表空间
  create database springBoot default character set utf8 collate utf8_bin;
  show tables;
  -- 使用表空间
  use springBoot;
  -- 创建表
  CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
  ~~~

### 2.添加用户

* 1.创建实体类

  ~~~java
  public class User {
      private Integer id;
      private String name;
      private Integer age;
  
      public Integer getId() {
          return id;
      }
  
      public void setId(Integer id) {
          this.id = id;
      }
  
      public String getName() {
          return name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  
      public Integer getAge() {
          return age;
      }
  
      public void setAge(Integer age) {
          this.age = age;
      }
  }
  ~~~

  

* 2.创建mappr接口异界映射xml

  ~~~xml
  <?xml version="1.0" encoding="UTF-8"?>
  <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
          "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
  <mapper namespace="com.cyn.mapper.UserMapper">
      <insert id="insertUser" parameterType="user" >
          insert into users(NAME,AGE) values (#{name},#{age})
      </insert>
  
      <select id="selectUserAll" resultType="user">
          select id,name,age from users
      </select>
  </mapper>
  ~~~

  ~~~java
  public interface UserMapper {
      /**
       * 用户添加
       * @param user
       */
      void insertUser(User user);
  
      /**
       * 查询所有用户
       * @return
       */
      List<User> selectUserAll();
  }
  
  ~~~

  

* 3.创建service业务层

  ~~~java
  接口
  public interface UserService {
      /**
       * 用户添加
       * @param user
       */
      void addUser(User user);
  
      /**
       * 查询所有用户
       * @return
       */
      List<User> findUserAll();
  }
  
  实现类
  @Service
  @Transactional
  public class UserServiceImpl  implements UserService {
  
      @Autowired(required = false)
      private UserMapper userMapper;
  
      @Override
      public void addUser(User user) {
          this.userMapper.insertUser(user);
      }
  
      /**
       * 查询所有用户
       *
       * @return
       */
      @Override
      public List<User> findUserAll() {
          return  this.userMapper.selectUserAll();
      }
  }
  ~~~

  

* 4.创建controller控制层

  ~~~java
  @Controller
  @RequestMapping("/user")
  public class UserController {
  
      @Autowired
      private UserService userService;
  
      /**
       * 页面跳转
       * @param page
       * @return
       */
      @RequestMapping("/{page}")
      public String showPage(@PathVariable String page){
          return page;
      }
  
      /**
       * 添加用户
       * @param user
       * @return
       */
      @RequestMapping("/addUser")
      public String addUser(User user){
          this.userService.addUser(user);
          return "ok";
      }
  
      @RequestMapping("/findUserAll")
      public String findUserAll(Model model){
          List<User> list = this.userService.findUserAll();
          model.addAttribute("list",list);
          return "showUser";
      }
  }
  ~~~

  

* 5.编写前台模板页面（thymeleaf），需要在src/main/resources下新增templates目录，视图页面存在此目录中

  ~~~html
  <!doctype html>
  <html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
  <head>
      <meta charset="UTF-8">
      <meta name="viewport"
            content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
      <meta http-equiv="X-UA-Compatible" content="ie=edge">
      <title>添加用户</title>
  </head>
  <body>
      <form th:action="@{/user/addUser}" action="" method="post">
          用户姓名：<input type="text" name="name"><br>
          用户年龄：<input type="text" name="age"><br>
          <input type="submit" value="提交">
      </form>
  </body>
  </html>
  ~~~

  

* 6.编写spring启动类

## 2019-10-10 SpringBoot学习-整合视图层技术（freemarker）

* 整合freemarker

  注：在src/main/resources下必须要有 templates目录。名称路径唯一确定

  * 1.创建项目

  * 2.引入springboot启动器，以及freemarker启动器

    ~~~xml
    	<!--继承spring-boot 父工程-->
        <parent>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-parent</artifactId>
            <version>2.1.6.RELEASE</version>
        </parent>	
    	<dependencies>
            <!--spring-boot-starter-web启动器-->
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-web</artifactId>
            </dependency>
            <!--spring-boot-starter-freemarker启动器-->
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-freemarker</artifactId>
            </dependency>
        </dependencies>
    ~~~

  * 3.创建freemarker模板

    ~~~html
    <!doctype html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>展示用户数据</title>
    </head>
    <body>
        <table border="1" align="center" width="50%">
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Age</td>
            </tr>
            <#list list as user>
                <tr>
                    <td>user.userId</td>
                    <td>user.userName</td>
                    <td>user.userAge</td>
                </tr>
            </#list>
        </table>
    </body>
    </html>
    ~~~

  * 4.新建controller 参考jsp

  * 5.新建启动器 参考jsp

## 2019-10-09 SpringBoot学习-整合视图层技术（jsp）

* 整合jsp

  * 1.创建项目

  * 2.修改pom.xml添加依赖

    ~~~xml
      	<!--父工程依赖-->
    	<parent>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-parent</artifactId>
            <version>2.1.6.RELEASE</version>
        </parent>
        <dependencies>
            <!--spring-boot-starter-web启动器，支持全栈式的web开发，包括了tomcat和springMVC等jar-->
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-web</artifactId>
            </dependency>
           
            <!--用于jsp的编写-->
            <!--jstl标签库-->
            <dependency>
                <groupId>javax.servlet</groupId>
                <artifactId>jstl</artifactId>
            </dependency>
            <!--jasper-->
            <dependency>
                <groupId>org.apache.tomcat.embed</groupId>
                <artifactId>tomcat-embed-jasper</artifactId>
                <scope>provided</scope>
            </dependency>
        </dependencies>
    ~~~

  * 3.创建springboot全局配置文件aplication.properties,配置jsp视图解析

    ~~~pr
    spring.mvc.view.prefix=/WEB-INF/jsp
    spring.mvc.view.suffix=.jsp
    ~~~

    

  * 4.创建controller

    ~~~java
    @Controller
    public class UserController {
        @RequestMapping("/userListController")
        public String showUser(Model model){
            List<Users> list = new ArrayList<>();
            list.add(new Users(1,"张三",12));
            list.add(new Users(2,"李四",13));
            list.add(new Users(3,"王五",14));
            model.addAttribute("list",list);
            return "userList";
        }
    }
    ~~~

  * 5.创建jsp

    ~~~jsp
    <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!doctype html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Document</title>
    </head>
    <body>
        <table border="1" align="center" width="50%">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
            </tr>
            <c:forEach items="${list}" var="user">
                <tr>
                    <td>${user.userId}</td>
                    <td>${user.userName}</td>
                    <td>${user.userAge}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
    </html>
    ~~~

    

  * 6.创建启动类

    ~~~java
    @SpringBootApplication
    @ServletComponentScan
    public class ApplicationStart {
        public static void main(String[] args) {
            SpringApplication.run(ApplicationStart.class,args);
        }
    }
    ~~~

    

## 2019-10-09 SpringBoot学习-文件上传

* 类似springMVC文件上传

  ~~~java
  @RestController // 该类下的所有方法返回为json，可以理解为@Controller @RequestBody 复合注解
  public class FileUploadController {
      /**
       * 文件上传(上传默认10mb)
       * @param filename
       * @return
       */
      @RequestMapping("/fileUploadController")
      public Map<String, Object> fileUpload(MultipartFile filename) throws IOException {
          Map<String,Object> map = new HashMap<>();
          System.out.println(filename.getOriginalFilename());
          filename.transferTo(new File("E:/"+filename.getOriginalFilename()));
          map.put("msg","OK");
          return map;
      }
  }
  ~~~

  

* 注意

  需要配置文件调整上传文件的大小

  application.properties 改配置文件需要放在classpath:resource下，名称唯一确定，位置必须是根目录

  ~~~java
  # 调整文件上传的最大上传大小
  spring.http.multipart.max-file-size=200MB
  spring.http.multipart.max-request-size=200MB
  ~~~

  

## 2019-10-09 SpringBoot学习-访问静态资源

* 1.SpringBoot从classpath/static下

  注意目录名称必须是static

* 2.servletContext下

  新建目录src/main/webapp，名称必须为webapp 

## 2019-10-09 SpringBoot学习-整合listener

* 需要根据不同需求选择不同的监听器

  ~~~java
  ServletContextListener -- servlet上下文监听器
  ~~~

  

* 1.通过注解扫描完成listener注册
  * 1.1编写listener
  * 1。2编写启动类，类似整合filter和servlet
* 2.通过方法完成listener注册
  * 2.1编写listener，无需注解
  * 2.2编写启动类，类似整合filter和servlet

## 2019-10-09 SpringBoot学习-整合filter

* 1.通过注解扫描完成filter注册

  * 1.1编写filter

    ~~~java
    @WebFilter(filterName = "FirstFilter",urlPatterns = "first")
    public class FirstFilter implements Filter {
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
        }
        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            System.out.println("进入filter");
            filterChain.doFilter(servletRequest,servletResponse);
            System.out.println("放行");
        }
        @Override
        public void destroy() {
        }
    }
    
    ~~~

  * 1.2springboot启动添加注解

    ~~~java
    @SpringBootApplication
    @ServletComponentScan  //在springboot启动时会扫描@webservlet @webFilter等注解，实例化该类
    public class ApplicationStart {
        public static void main(String[] args) {
            SpringApplication.run(ApplicationStart.class,args);
        }
    }
    ~~~

    

* 2.通过方法完成filter注册

  * 2.1 新建filter，不需要注解

    ~~~java
    //@WebFilter(filterName = "FirstFilter",urlPatterns = {"*.do","*.jsp"})
    //@WebFilter(filterName = "FirstFilter",urlPatterns = "/first")
    public class SecondFilter implements Filter {
    
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
    
        }
    
        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            System.out.println("进入SecondFilter");
            filterChain.doFilter(servletRequest,servletResponse);
            System.out.println("放行");
        }
    
        @Override
        public void destroy() {
    
        }
    }
    ~~~

  * 2.2 springboot添加filter注册 方法

    ~~~java
    	/**
         * 通过方法注册filter
         * @return
         */
        @Bean
        public FilterRegistrationBean filterRegistrationBean(){
            FilterRegistrationBean bean = new FilterRegistrationBean(new SecondFilter());
            //bean.addUrlPatterns(new String[]{"*.do","*.jsp"});
            bean.addUrlPatterns("/second");
            return bean;
        }
    ~~~

    

## 2019-10-09 SpringBoot学习-整合servlet

* 1.通过注解扫描完成servlet组件的注册

  * 1.1 新建servlet

    ~~~java
    @WebServlet(name = "FirstServlet",urlPatterns = "/first")
    public class FirstServlet extends HttpServlet {
      @Override
      protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { }
    }
    ~~~

    

  * 1.2springboot启动添加注解

    ~~~java
    @SpringBootApplication
    @ServletComponentScan  //在springboot启动时会扫描@webservlet @webFilter等注解，实例化该类
    public class ApplicationStart {
        public static void main(String[] args) {
            SpringApplication.run(ApplicationStart.class,args);
        }
    }
    ~~~

* 2.通过方法完成servlet组件的注册

  * 2.1 新建一个servlet，不需要注解

    ~~~java
    public class SecondServlet extends HttpServlet {
        @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            System.out.println("secondServlet!!!");
        }
    }
    ~~~

    

  * 2.2 springboot启动类添加servlet注册方法

    ~~~java
        /**
         * 通过方法注册servlet
         * @return
         */
        @Bean
        public ServletRegistrationBean servletRegistrationBean(){
            ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());
            bean.addUrlMappings("/second");
            return bean;
        }
    ~~~

    

## 2019-10-09 SpringBoot学习-helloworld

* 步骤

  ~~~java
  1.新建maven项目，pom依赖为
      <modelVersion>4.0.0</modelVersion>
      <!--继承spring-boot 父工程-->
      <parent>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-parent</artifactId>
          <version>2.1.6.RELEASE</version>
      </parent>
      <groupId>com.cyn</groupId>
      <artifactId>spring-boot</artifactId>
      <version>1.0-SNAPSHOT</version>
      <!--修改jdk版本-->
      <!--spring-boot 2.0 需要jdk8以上-->
     <!-- <properties>
          <java-version>1.8</java-version>
      <properties/>-->
      <dependencies>
          <!--spring-boot启动器 共44个-->
          <!--本质是一系列jar包的集合-->
  
          <!--spring-boot-starter-web启动器，支持全栈式的web开发，包括了tomcat和springMVC等jar-->
          <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-web</artifactId>
          </dependency>
  
          <!--spring-boot-starter-jdbc启动器，支持spring以jdbc方式操作数据库jar的集合-->
          <!--spring-boot-starter-redis启动器，支持redis的键值存储方式操作数据库jar的集合-->
      </dependencies>	
      
  2.新建controller,编写hellworldcontroller
  3.编写springboot启动类
  	编写启动类需要注意：启动器位置需要和controller位于同一个包下或者上级包目录。不能是子包或者平级目录
  ~~~

  

## 2019-09-27 SpringMVC-文件下载上传

* 步骤

  ~~~javascript
  1.导入commons-fileupload,commons-io 
  2.前台页面一律用post(2GB)字节流  get(2kb)字符流
  3.配置springMVC解析器：MultipartResolver ,ExceptionResolver
  ~~~

  

* 需要jar

  ~~~java
  pom.xml--
  		<dependency>
              <groupId>commons-fileupload</groupId>
              <artifactId>commons-fileupload</artifactId>
              <version>1.3.1</version>
          </dependency>
          <dependency>
              <groupId>commons-io</groupId>
              <artifactId>commons-io</artifactId>
              <version>2.6</version>
          </dependency>
  ~~~

* 文件下载

  * 访问资源相应头的时候，没有设置content-disposition,浏览器按照默认的inline 处理，能下载就下载，不能下载就显示

    ~~~java
    	@RequestMapping(value = "/download")
        @ResponseBody
        public void download(String fileName, HttpServletResponse response, HttpServletRequest request) throws IOException {
            //字符流
            // response.getWriter();
            //字节流 设置响应中该文件进行下载
            response.setHeader("Content-Disposition","attachment;filename=bbb.txt");
            ServletOutputStream outputStream =  response.getOutputStream();
            // 资源文件夹的完整路径
            String path =  request.getServletContext().getRealPath("static");
            System.out.println(path);
            File file = new File(path,fileName);
            byte[] bytes =  FileUtils.readFileToByteArray(file);
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();
        }
    ~~~

* 文件上传

  ~~~js
  <form> 表单 enctype 属性取值
  1、默认值：application/x-www-form-urlencoded   用于普通表单数据
  2、text/plain 大量文字使用，例如邮件，论文
  3、multipart/form-data 表单中包含二进制文件
  ~~~
  


## 2019-09-19 SpringMVC学习

* 重要组件
  * DispatcherServlet：前端控制器，接受所有请求
  * HandlerMapping：解析请求格式，判断希望执行那个具体方法
  * HandlerAdapter：负责调用具体的方法
  * ViewResovler：试图解析器，解析结果，准备跳转到具体物理视图
* 配置文件配置springMVC
  * web.xml(WEB-INF目录下) --> springMVC.xml(src/resource文件夹下)
* 注解形式配置springMVC

## 2019-09-01 cglib动态代理模式

* 优点
  * 基于字节码文件，生成真实代理对象的子类
  * 运行效率高于JDK动态代理
  * 不需要实现接口
  * 

* 缺点

  * 需要导入jar

* ***springAOP***使用时，只要出现类型proxy和真实对象转换异常,需要关注下面的配置文件

  ~~~java
  <!--
      proxy-target-class
      true cglib动态代理 注解
      false jdk动态代理
      -->
      <aop:aspectj-autoproxy proxy-target-class="true"></aop:aspectj-autoproxy>
  ~~~

  

## 2019-08-29 代理设计模式

* 什么是代理设计模式 
  1. 真实对象（总裁）
  2. 代理对象（秘书）
  3. 抽象对象或抽象功能（谈合作）

* 代理设计模式优点
  1. 保护真实对象
  2. 让真实对象功能更明确
  3. 增强拓展性

* *静态代理* 设计模式（由代理对象代理真实对象的所有功能）
  1. 自己编写代理类
  2. 每个代理的功能需要单独编写(静态代理不足点)


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
