# SpringBoot集成MybatisPlus

## Mybatis-Plus Generator逆向工程

```java
package top.simba1949;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/20 15:23
 */
public class MybatisPlusGenerator {
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("F://");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("simba@onlying.cn");

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("I%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("19491001");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/mybatis?characterEncoding=utf8");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        strategy.setTablePrefix(new String[] { "tlog_", "tsys_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("top.simba1949")
                .setController("controller")
                .setService("service")
                .setServiceImpl("service.impl")
                .setMapper("mapper")
                .setEntity("common").setXml("mapper");
        mpg.setPackageInfo(pc);

        // 执行生成
        mpg.execute();
    }
}
```

## 利用 SpringBoot 配置文件集成

### 在 pom.xml 添加依赖

```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.1.12</version>
</dependency>
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.0.5</version>
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
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8
    username: root
    password: 19491001
    driver-class-name: com.mysql.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource
mybatis-plus:
  # *Mapper.xml 配置文件位置
  mapper-locations: classapth*:top/simba1949/mapper/*Mapper.xml
  # 实体类取别名
  type-aliases-package: top.simba1949.common

```

### Application.java

```java
package top.simba1949;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @MapperScan("top.simba1949.mapper") 必须添加来扫描 *Mapper 配置文件
 * @author simba1949@outlook.com
 * @date 2018/10/20 15:28
 */
@MapperScan("top.simba1949.mapper")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

利用 Mybatis-Plus Generator 生成实体类、dao层、service层、controller层的代码，直接拷贝进项目即可。

## 利用 Mybatis-Plus(Mybatis) 配置文件集成

### 在 pom.xml 添加依赖

```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.1.12</version>
</dependency>
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.0.5</version>
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

### MybatisPlus(Mybatis) 相关配置

#### mybatis.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>

</configuration>
```

#### jdbc.properties

```properties
jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8
jdbc.username=root
jdbc.password=19491001
```

#### applicationContext-mybatis.xml

***mybatis-plus 的基本配置是基于 mybatis 基本配置而配置， 但是需要将  mybatis 的 sqlSessionFactory 替换成  mybatis-plus 的 sqlSessionFactory ，即将 org.mybatis.spring.SqlSessionFactoryBean 替换成com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean，这样 mybatis-plus 知道数据源、mapper 配置为文件以及包别名所在位置***（十分重要，否则找不到 mapper 配置文件）

****

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


    <!--mybatis plus的基本配置是基于 mybatis基本配置而配置，
        但是需要将 mybatis 的sqlSessionFactory替换成 mybatis-plus的sqlSessionFactory
        即将org.mybatis.spring.SqlSessionFactoryBean替换成com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean
        这样mybatis-plus 知道数据源、mapper配置为文件以及包别名所在位置
    -->
    <bean id="sqlSessionFactory" class="com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean">
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
        <property name="typeAliasesPackage" value="top.simba1949.common"></property>
    </bean>
    <!--mapper扫描配置-->
    <bean id="mapperScannerConfigurer" class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <!--指定dao接口的路径-->
        <property name="basePackage" value="top.simba1949.mapper"></property>
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"></property>
    </bean>
</beans>
```

### Application.java

```java
package top.simba1949;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @MapperScan("top.simba1949.mapper") 必须添加来扫描 *Mapper 配置文件
 * @author simba1949@outlook.com
 * @date 2018/10/20 15:28
 */
@MapperScan("top.simba1949.mapper")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

利用 Mybatis-Plus Generator 生成实体类、dao层、service层、controller层的代码，直接拷贝进项目即可。