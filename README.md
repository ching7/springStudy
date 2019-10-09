# Spring学习日记

---

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
