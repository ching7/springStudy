# Spring框架常用注解介绍

## @Import注解 —— 导入资源

* 自定义类导入spring容器

  1. 创建需要导入的类

     ~~~java
     public class CatImport {
     }
     ~~~

  2. 启动时手动导入

     ```java
     @Import(CatImport.class})
     @SpringBootApplication(scanBasePackages = {"com.cyn.config"})
     public class SpringAnnotationApplication {
         public static void main(String[] args) {
             ConfigurableApplicationContext context = SpringApplication.run(SpringAnnotationApplication.class, args);
             CatImport catImport = context.getBean(CatImport.class);
             System.out.println(catImport);
         }
     }
     ```

  3. 输出

     ~~~properties
     com.cyn.config.CatImport@35f26e72
     ~~~

     从输出结果知，`@Import`注解把用到的bean导入到了当前容器中。

## @ConfigurationProperties —— 配置加载

常用于个性化配置文件。编写项目代码时，我们要求更灵活的配置，更好的模块化整合。通常情况下，我们可以使用 `@Value` 注解或着使用 `Spring Environmen bean `访问这些属性，是这种注入配置方式有时显得很笨重。我们将使用更安全的方式(`@ConfigurationProperties` )来获取这些属性

`@ConfigurationProperties` 的基本用法非常简单:我们为每个要捕获的外部属性提供一个带有字段的类。请注意以下几点:

- 前缀定义了哪些外部属性将绑定到类的字段上
- 根据 Spring Boot 宽松的绑定规则，类的属性名称必须与外部属性的名称匹配
- 我们可以简单地用一个值初始化一个字段来定义一个默认值
- 类本身可以是包私有的
- 类的字段必须有公共 setter 方法

**参考：**

> @ConfigurationProperties 注解使用姿势，这一篇就够了](https://www.cnblogs.com/FraserYu/p/11261916.html)

## @PostConstruct  —— Bean初始化

从依赖注入的字面意思就可以知道，要将对象p注入到对象a，那么首先就必须得生成对象a和对象p，才能执行注入。所以，如果一个类A中有个成员变量p被@Autowried注解，那么@Autowired注入是发生在A的构造方法执行完之后的。

如果想在生成对象时完成某些初始化操作，而偏偏这些初始化操作又依赖于依赖注入，那么久无法在构造函数中实现。为此，可以使用@PostConstruct注解一个方法来完成初始化，@PostConstruct注解的方法将会在依赖注入完成后被自动调用。

~~~java
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
~~~

测试：

~~~java
@SpringBootApplication(scanBasePackages = {"com.cyn"})
public class SpringAnnotationApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringAnnotationApplication.class, args);
        PostConstructDemo postConstructDemo = context.getBean(PostConstructDemo.class);
    }

}
~~~

输出：

~~~properties
ParentBean construct
DemoA{name='DemoA init'}
ParentBean init
~~~

可以看出执行顺序： Constructor >> @Autowired >> @PostConstruct