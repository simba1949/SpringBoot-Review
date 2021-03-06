# SpringBoot 发送邮件

## 前言

spring-boot-starter-mail 官方文档：https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-email.html

spring-boot-starter-mail maven地址：https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-mail

## 添加依赖

在 pom.xml 添加依赖

```xml
<!-- springboot 发送邮件 start -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
<!-- springboot 发送邮件 end -->
```

## 邮件在 application.yml 配置

```yaml
server:
  port: 8081
spring:
  mail:
    # 邮箱服务器地址
    host: smtp.qq.com
    # 邮箱地址
    username: 932759972@qq.com
    # 邮箱密码或者授权码
    password: thgeydcvgpntbdfi
    properties:
      mail:
        smtp:
          auth: true
          timeout: 25000
```

## EmailServiceImpl.java

```java
package top.simba1949.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import top.simba1949.service.IEmailService;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/19 22:23
 */
@Service
public class EmailServiceImpl implements IEmailService {

    @Value("${spring.mail.username}")
    private String sender;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendSimpleMail(String receiver, String title, String content) {
        // 创建邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        // 设置邮件发送人地址
        message.setFrom(sender);
        // 设置邮件接收人地址
        message.setTo(receiver);

        // 设置邮件标题
        message.setSubject(title);
        // 设置邮件内容
        message.setText(content);

        javaMailSender.send(message);
    }
}
```

