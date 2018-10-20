# SpringBoot 集成 MyBatis

## 前言

数据库驱动 maven地址：https://mvnrepository.com/artifact/mysql/mysql-connector-java

druid maven地址：https://mvnrepository.com/artifact/com.alibaba/druid

mybatis-spring-boot-starter maven地址：https://mvnrepository.com/artifact/org.mybatis.spring.boot/mybatis-spring-boot-starter

注意：mybatis-spring-boot-starter 1.3.2 版本有些问题，暂时不建议使用

## SpringBoot 配置文件集成

项目名：SpringBoot-Mybatis-SpringBootConfigYml

### pom.xml

SpringBoot 集成 Mybatis 需要添加的依赖如下

```xml
<!--数据库驱动必选-->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
<!--数据源，自行选择-->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.1.12</version>
</dependency>
<!--springboot集成mybatis只需要引入mybatis-spring-boot-starter.jar即可
	mybatis-spring-boot-starter 会自动引入 mybatis.jar 和 mybatis-spring.jar等依赖
-->
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>1.3.1</version>
</dependency>
```

### application.yml

```yaml
server:
  port: 8081

# 数据库基本配置
spring:
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/mybatis
    username: root
    password: 19491001
    type: com.alibaba.druid.pool.DruidDataSource
# mybatis 配置
mybatis:
  type-aliases-package: top.simba1949.common
  mapper-locations: classpath:top/simba1949/mapper/*Mapper.xml
```

### application.java

```java
package top.simba1949;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @mapperscan 指定被扫描的 *mapper.xml 所在的包路径
 * @author simba1949@outlook.com
 * @date 2018/10/20 8:02
 */
@MapperScan(basePackages = "top.simba1949.mapper")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

注意：一定要添加 @MapperScan(basePackages = "top.simba1949.mapper") 

## Mybatis 配置文件集成

### pom.xml

SpringBoot 集成 Mybatis 需要添加的依赖如下

```xml
 <!--数据库驱动必选-->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
<!--数据源，自行选择-->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.1.12</version>
</dependency>
<!--springboot集成mybatis只需要引入mybatis-spring-boot-starter.jar即可
            mybatis-spring-boot-starter 会自动引入 mybatis.jar 和 mybatis-spring.jar等依赖
        -->
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>1.3.1</version>
</dependency>
<!--涉及到事务管理需要添加 aop 依赖-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

### application.yml

```yaml
server:
  port: 8081
```

### application.java

```java
package top.simba1949;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @mapperscan 指定被扫描的 *mapper.xml 所在的包路径
 * @author simba1949@outlook.com
 * @date 2018/10/20 8:02
 */
@MapperScan(basePackages = "top.simba1949.mapper")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

### applicationContext-mybatis.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd
        http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
        "> <!-- bean definitions here -->

    <!--数据连接信息-->
    <context:property-placeholder location="classpath*:jdbc.properties"></context:property-placeholder>
    <!--声明式事务aop配置-->
    <aop:config>
        <aop:pointcut id="aoppointcut" expression="execution(* top.simba1949.service.impl.*.*(..))"></aop:pointcut>
        <aop:advisor advice-ref="txadvice" pointcut-ref="aoppointcut"></aop:advisor>
    </aop:config>
    <!--事务的传播特性-->
    <tx:advice id="txadvice" transaction-manager="transactionManager">
        <tx:attributes>
            <!--tx:method表示哪些方法需要开启事务，propagation表示必须要求，
                isolation表示事物隔离级别,rollback-for表示发生异常回滚
            -->
            <tx:method name="add*" propagation="REQUIRED" isolation="DEFAULT" rollback-for="java.lang.Exception"/>
            <tx:method name="save*" propagation="REQUIRED" isolation="DEFAULT" rollback-for="java.lang.Exception"/>
            <tx:method name="insert*" propagation="REQUIRED" isolation="DEFAULT" rollback-for="java.lang.Exception"/>
            <tx:method name="update*" propagation="REQUIRED" isolation="DEFAULT" rollback-for="java.lang.Exception"/>
            <tx:method name="modify*" propagation="REQUIRED" isolation="DEFAULT" rollback-for="java.lang.Exception"/>
            <tx:method name="delete*" propagation="REQUIRED" isolation="DEFAULT" rollback-for="java.lang.Exception"/>

            <tx:method name="query*" read-only="true"></tx:method>
            <tx:method name="select*" read-only="true"></tx:method>
            <tx:method name="find*" read-only="true"></tx:method>
        </tx:attributes>
    </tx:advice>
    <!--事务管理器-->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"></property>
    </bean>
    <!--数据源-->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="${jdbc.driverClassName}"></property>
        <property name="url" value="${jdbc.url}"></property>
        <property name="username" value="${jdbc.username}"></property>
        <property name="password" value="${jdbc.password}"></property>
    </bean>


    <!--mybatis的基本配置-->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <!--数据源配置-->
        <property name="dataSource" ref="dataSource"></property>
        <!--告诉spring，mybatis配置文件位置-->
        <property name="configLocation" value="classpath:mybatis.xml"></property>
        <!--告诉spring，mybatisMpapper配置文件位置-->
        <property name="mapperLocations">
            <array>
                <value>classpath*:top/simba1949/mapper/*Mapper.xml</value>
            </array>
        </property>
        <!--给包取别名-->
        <property name="typeAliasesPackage" value="top.simba1949.model"></property>
    </bean>
    <!--mapper扫描配置-->
    <bean id="mapperScannerConfigurer" class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <!--指定dao接口的路径-->
        <property name="basePackage" value="top.simba1949.mapper"></property>
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"></property>
    </bean>
</beans>
```

### jdbc.properties

```properties
jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8
jdbc.username=root
jdbc.password=19491001
```

### mybatis.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>

</configuration>
```

### 导入配置文件 MybatisConfig.java

```java
package top.simba1949.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/20 9:57
 */
@Configuration
@ImportResource(locations = "classpath*:applicationContext-mybatis.xml")
public class MybatisConfig {
}
```

### CountryMaper.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="top.simba1949.mapper.CountryMapper">

    <insert id="insert">
        insert into
        country(countryname, countrycode)
        values (#{countryName}, #{countryCode})
    </insert>

    <delete id="delete">
        delete from
        country
        where
        id = #{id}
    </delete>

    <update id="update">
        update country
        <set>
            <if test="null != countryName and '' != countryName">countryname = #{countryName},</if>
            <if test="null != countryCode and '' != countryCode">countrycode = #{countryCode},</if>
            <!--为了避免SQL错误产生，id = #{id} 的赋值仍然保留-->
            id = #{id},
        </set>
        where id = #{id}
    </update>

    <select id="getList" resultType="top.simba1949.common.CountryCommon">
        select
        id, countryname, countrycode
        from
        country
        <where>
            <if test="null != commonStart.id and commonStart.id > 0">and id = #{commonStart.id}</if>
            <if test="null != commonStart.countryName and '' != commonStart.countryName">and countryname = #{commonStart.countryName}</if>
            <if test="null != commonStart.countryCode and '' != commonStart.countryCode">and countrycode = #{commonStart.countryCode}</if>
        </where>

    </select>
</mapper>
```

