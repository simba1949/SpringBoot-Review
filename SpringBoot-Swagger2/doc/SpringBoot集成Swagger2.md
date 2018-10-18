# SpringBoot 集成 Swagger2

## 前言

swagger2 官网：https://swagger.io/

swagger2 学习笔记：https://blog.csdn.net/SIMBA1949/article/details/80926126

maven 地址

* springfox-swagger2：http://mvnrepository.com/artifact/io.springfox/springfox-swagger2
* springfox-swagger-ui：http://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui

## 什么是swagger2

> 编写和维护接口文档是每个程序员的职责，根据 Swagger2 可以快速帮助我们编写最新的API接口文档，再也不用担心开会前仍忙于整理各种资料了，间接提升了团队开发的沟通效率。常用注解swagger通过注解表明该接口会生成文档，包括接口名、请求方法、参数、返回信息的等等。

## 在 pom.xml 添加依赖

```xml
<!-- swagger2 start-->
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.9.2</version>
</dependency>
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.9.2</version>
</dependency>
<!-- swagger2 end-->
```

## 创建 swagger2 配置类

```java
package top.simba1949.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/18 15:14
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    /**
    * swagger2 启动后，通过createRestApi函数创建Docket的Bean，
    * apiInfo() 用来创建该Api的基本信息（这些基本信息会展现在文档页面中）。
    * select() 函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现，
    * 本例采用指定扫描的包路径来定义，Swagger会扫描该包下所有Controller定义的API，并产生文档内容（除了被@ApiIgnore指定的请求）。
    * @return
    */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("top.simba1949.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot 中使用 Swagger2 构建 RestFul APIs")
                .description("摘要")
                .termsOfServiceUrl("http://localhost:8081/")
                .version("1.0")
                .build();
    }
}
```

访问 http://localhost:8081/swagger-ui.html 即可