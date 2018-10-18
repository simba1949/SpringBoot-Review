# SpringBoot 集成 SpringTask

> SpringTask，可以将它比作一个轻量级的 Quartz，而且使用起来很简单，除spring相关的包外不需要额外的包，而且支持注解和配置文件两种形式。 

## 官方文档

官方文档网址：https://docs.spring.io/spring/docs/current/spring-framework-reference/integration.html#scheduling

## 基于注解配置

### 第一步

在springboot启动类中添加注解@EnableScheduling

```java
package top.simba1949;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 * @EnableScheduling 开启 schedule 定时任务支持
 * @author simba1949@outlook.com
 * @date 2018/10/18 10:54
 */
@EnableScheduling
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

### 第二步

编写定时任务

```java
package top.simba1949.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/18 11:29
 */
@Component
public class MyTask {
    /**
     * @Scheduled(cron = "0/5 * * * * ?") 七子表达式
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void doTask(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(format.format(new Date()));
    }
}
```

## 基于配置文件

### 第一步

创建 applicationContext-springTask.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:task="http://www.springframework.org/schema/task"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.2.xsd
        http://www.springframework.org/schema/task http://www.springframework.org/schema/task/spring-task.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">

    <!-- 扫描组件 -->
    <context:component-scan base-package="top.simba1949.schedule" />
    <!-- 配置调度器,声明十个线程的池 -->
    <task:scheduler id="myScheduler" pool-size="10"/>
    <!-- 配置任务 -->
    <task:scheduled-tasks scheduler="myScheduler">
        <!--ref引用的定时任务的Bean，method指定该bean要执行的方法-->
        <task:scheduled ref="myTask" method="doTask" cron="0/5 * * * * ? "/>
        <!--配置定时任务2-->
        <task:scheduled ref="myTaskTwo" method="doTask" cron="0/3 * * * * ? "/>
    </task:scheduled-tasks>

</beans>
```

### 第二步

将配置文件加入spring容器管理

```java
package top.simba1949.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/18 14:34
 */
@Configuration
@ImportResource(locations = "classpath:applicationContext-springTask.xml")
public class TaskConfig {
}
```

### 第三步

编写定时任务

```java
package top.simba1949.schedule;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/18 11:29
 */
@Component
public class MyTask {

    public void doTask(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(format.format(new Date()));
    }
}
```

定时任务2

```java
package top.simba1949.schedule;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/18 14:32
 */
@Component
public class MyTaskTwo {

    public void doTask(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(format.format(new Date()));
    }
}
```

