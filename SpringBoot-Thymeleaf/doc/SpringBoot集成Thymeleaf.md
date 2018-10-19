# SpringBoot 集成 Thymeleaf

## 前言

Thymeleaf 官网：https://www.thymeleaf.org/

Thymeleaf maven 地址：https://mvnrepository.com/artifact/org.thymeleaf/thymeleaf

spring-boot-starter-thymeleaf maven 地址：https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-thymeleaf

## 集成

在 pom.xml 添加依赖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

UserController.java

```java
package top.simba1949.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/19 21:41
 *  a.这里不是走 HTTP + JSON 模式，使用了 @Controller 而不是先前的 @RestController
 *  b.方法返回值是 String 类型，和 application.yml 配置的 Thymeleaf 文件配置路径下的各个 *.html 文件名一致。
 *    这样才会准确地把数据渲染到页面里面进行展示。
 *  c.用 Model 类，向 Model 加入数据，该数据在 Thymeleaf 取值使用 ${key} 即可。
 */
@Controller
public class UserController {

    @GetMapping("/say")
    public String sayHello(Model model){
        model.addAttribute("say","Welcome to Thymeleaf");
        return "Index.html";
    }
}
```

