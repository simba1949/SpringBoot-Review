# SpringBoot 集成 Actuator 监控系统

## 前言

actuator 官方文档网址：https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready.html

actuator maven网址：https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-actuator

## 在 pom.xml 添加依赖

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

在配置文件中暴露所有web监控配置（仅在测试中使用）

```yaml
server:
  port: 8081
# 暴露所有web监控配置
management:
  endpoints:
    web:
      exposure:
        include: "*"
```

