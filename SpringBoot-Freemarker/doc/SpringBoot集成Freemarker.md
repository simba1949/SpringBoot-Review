# SpringBoot 集成 Freemarker

## 前言

Freemarker 官网：https://freemarker.apache.org/

Freemarker 手册网址：http://freemarker.foofun.cn/

spring-boot-starter-freemarker maven地址：http://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-freemarker

Freemarker maven地址：http://mvnrepository.com/artifact/org.freemarker/freemarker

Freemarker 使用手册：https://blog.csdn.net/SIMBA1949/article/details/82712319

## 集成

### 在 pom.xml 添加依赖

```xml
<!--springboot默认支持freemarker,无需添加版本号-->
<!-- freemarker start -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-freemarker</artifactId>
</dependency>
<!-- freemarker end  -->
```

### templates 目录

在 src/resources目录下创建 templates 文件夹，用于放置 freemarker 模板文件

HelloFreemarker.ftl 文件

```html
<!doctype html>
<html lang="en">
<html>
<head>
    <title>Hello Freemarker</title>
</head>
<body>

${user}

</body>
</html>
```

### application.yml

```yaml
server:
  port: 8081
```

### UserController.java

```java
package top.simba1949.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/18 22:51
 *  a.这里不是走 HTTP + JSON 模式，使用了 @Controller 而不是先前的 @RestController
 *  b.方法返回值是 String 类型，和 application.yml 配置的 Freemarker 文件配置路径下的各个 *.ftl 文件名一致。
 *    这样才会准确地把数据渲染到 ftl 文件里面进行展示。
 *  c.用 Model 类，向 Model 加入数据，该数据在 Freemarker 取值使用 ${key} 即可。
 */
@Controller
public class UserController {

    @RequestMapping("/say")
    public String sayHello(Model model){
        model.addAttribute("user","Hello Freemarker!!!");
        return "HelloFreemarker";
    }
}
```

### Application.java

```java
package top.simba1949;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/18 22:27
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

