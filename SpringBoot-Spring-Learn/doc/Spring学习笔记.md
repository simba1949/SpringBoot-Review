# Spring学习笔记

## SpringEL 表达式

### 介绍

Spring EL表达式语言，支持在 xml 和注解中使用表达式，类似于 JSP 的 EL 表达式语言

Spring 开发中经常涉及调用各种资源的情况，包括普通文件、网址、配置文件、系统环境变量等，我们可以使用 Spring 的表达式语言实现资源的注入

Spring 主要在注解 @Value 的参数中使用 EL 表达式

本文实现以下几种情况

- 注入普通的字符串
- 注入操作系统属性
- 注入表达式运算结果
- 注入其他 Bean 的属性
- 注入文件内容
- 注入网址内容
- 注入文件中的属性

```java
package top.simba1949.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/19 23:35
 */
@Component
public class ElExpression {

    /**
     * 注入一个普通的字符串
     */
    @Value("注入一个普通的字符串")
    private String ordinaryString;
    /**
     * 从配置文件注入一个字符串
     */
    @Value("${ordinary.string}")
    private String configString;
    /**
     * 注入操作系统的属性
     */
    @Value("#{ systemProperties['os.name']}")
    private String osName;
    /**
     * 注入运算表达式的结果
     */
    @Value("#{ T(Math).random()}")
    private Double randomNumber;
    /**
     * 注入 Spring 容器中 Bean 的属性
     */
    @Value("#{stringBean.ordinaryString}")
    private String beanProperty;
    /**
     * 注入文件
     */
    @Value("classpath:config/file.properties")
    private Resource fileResource;

    /**
     * 注入网址内容
     */
    @Value("https://www.baidu.com")
    private Resource urlResource;

    public void print(){
        System.out.println("注入一个普通的字符串===" + ordinaryString);
        System.err.println("从配置文件注入一个字符串===" + configString);
        System.out.println("注入操作系统的属性" + osName);
        System.err.println("注入运算表达式的结果===" + randomNumber);
        System.out.println("注入 Spring 容器中 Bean 的属性===" + beanProperty);
        System.err.println("注入文件===" + fileResource);
        System.out.println("注入网址内容===" + urlResource);
    }

}
```