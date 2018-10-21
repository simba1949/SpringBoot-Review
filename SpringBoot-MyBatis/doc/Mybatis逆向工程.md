# Mybatis逆向工程

## 配置说明

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
<generatorConfiguration>
    <!-- properties 选配，最多配置一个
    用于指定一个需要在配置中解析使用的外部属性文件，引入属性文件后，可以使用${property}获取值
    <properties resource="" ></properties> resource：指定classpath下的属性文件 eg：folder/generatorConfig.xml
    <properties url=""></properties> url：指定文件系统上的特定位置 eg：file:///C:/folder/generatorConfig.xml
    -->

    <!-- classPathEntry 选配，可以配置多个
    标签通过属性 location 指定驱动路径
    <classPathEntry location="" />
    -->

    <!--
       context标签
           id:
           defaultModelType：定义了MBG如何生成实体类，
                可选值：
                    conditionnal：如果一个表的主键只有一个字段，那么不会为该字段生成单独的实体类，二是会将该字段合并到基本实体类中
                    flat：为每张表生成一个实体类，该实体类包含表中所有字段
                    hierarchical：
           targetRuntime：指定生成的代码的运行时环境
                 可选值：
                    Mybatis3：默认值
                    MyBatis3Simple
           introspectedColumnImpl:

    <context id="mysql" defaultModelType="flat">
         0个或多个
        <property name="" value=""></property>
        eg：
        自动给关键字添加分隔符
        <property name="autoDelimitKeywords" value="true"></property>
        <property name="beginningDelimiter" value="'"></property>
        <property name="endingDelimiter" value="'"></property>

        0个或多个，配置插件
        <plugin type="org.mybatis.generator.plugins.CachePlugin">
            <property name="" value=""></property>
        </plugin>

        0个或1个，配置如何生成注释信息，type有默认值
        <commentGenerator type="">
            阻止生成注释，默认为false
            <property name="suppressAllComments" value="true"></property>
            阻止生成的注释包含时间戳，默认为false
            <property name="suppressDate" value="true"></property>
            注释是否添加数据库表的备注信息，默认为false
            <property name="addRemarkComments" value="true"></property>
        </commentGenerator>

        必填，只能有一个
        <jdbcConnection driverClass="" connectionURL="" userId="" password=""></jdbcConnection>

         0个或1个，指定jdbc类型和java的转换，type默认值即可
         <javaTypeResolver type="">
            <property name="forceBigDecimals" value="false"></property>
        </javaTypeResolver>

        1个，用于控制生成的实体类
        <javaModelGenerator targetPackage="" targetProject="">
                targetPackage：生成实体类存放的包名
                targetProject：指定目标项目路径，可以使用绝对路径或者相对路径
            <property name="constructorBased" value="true"></property>
                constructorBased为true就会使用构造方法入参，为false使用setter方法入参，默认为false
            <property name="enableSubPackages" value="false"></property>
                enableSubPackages 如果为true，MBG会根据catalog和schema来生成子包，如果为false就会直接使用targetPackage属性，默认为false
            <property name="immutable" value="false"></property>
                用于配置实体类属性是否可变，如果为true，不管constructorBased设置，都会使用构造方法入参不会生成setter方法。如果为false实体类属性可以改变，默认为false
            <property name="rootClass" value="类的全限定名"></property>
                设置所有实体类的基类
            <property name="trimStrings" value="false"></property>
                判断是否对数据库查询结果进行trim操作，默认为false
        </javaModelGenerator>

        最多配置一个，用于配置SQL映射生成器（Mapper.xml）的属性
        <sqlMapGenerator targetPackage="" targetProject="">
                targetPackage：包名
                targetProject：项目路径
            <property name="enableSubPackages" value="false"></property>
                enableSubPackages如果为true，MBG会根据catalog和schema来生成子包，为false，就直接用targetPackage属性，默认为false
        </sqlMapGenerator>

        最多配置一个，用于生成mapper接口
        <javaClientGenerator type="" targetPackage="" targetProject="" implementationPackage=""></javaClientGenerator>
            type：
                MyBatis3：ANNOTATEDMAPPER、MIXEDMAPPER、XMLMAPPER
                MyBtais3Simple：ANNOTATEDMAPPER、XMLMAPPER
            targetPackage：生成mapper接口存放的包名
            targetProject：指定目标项目路径，绝对路径或者相对路径
            implementationPackage：

        <table tableName=""></table>
        // TODO
    </context>
    -->
    <!--指定数据库驱动路径-->
    <classPathEntry location="./mysql-connector-java-5.1.40.jar"/>
    <context id="mysql" defaultModelType="flat" targetRuntime="MyBatis3Simple">
        <!-- 生成的Java文件的编码 -->
        <property name="javaFileEncoding" value="UTF-8" />
        <!-- 格式化java代码 -->
        <property name="javaFormatter" value="org.mybatis.generator.api.dom.DefaultJavaFormatter" />
        <!-- 格式化XML代码 -->
        <property name="xmlFormatter" value="org.mybatis.generator.api.dom.DefaultXmlFormatter" />
        <!--添加分隔符-->
        <property name="beginningDelimiter" value="'"></property>
        <property name="endingDelimiter" value="'"></property>
        <!--生成注释信息的配置-->
        <commentGenerator>
            <property name="suppressDate" value="true"></property>
            <property name="addRemarkComments" value="true"></property>
        </commentGenerator>
        <!--数据库连接信息-->
        <jdbcConnection
                driverClass="com.mysql.jdbc.Driver"
                connectionURL="jdbc:mysql://localhost:3306/mybatis"
                userId="root"
                password="19491001">
        </jdbcConnection>
        <!--生成实体类的配置-->
        <javaModelGenerator targetPackage="top.simba1949.common" targetProject="F:/java">
        </javaModelGenerator>
        <!--生成mapper.xml的配置-->
        <sqlMapGenerator targetPackage="top.simba1949.mapper" targetProject="F:/java"></sqlMapGenerator>
        <!--生成mapper接口的配置-->
        <javaClientGenerator type="XMLMAPPER" targetPackage="top.simba1949.mapper" targetProject="F:/java"></javaClientGenerator>
        <!--表的配置-->
        <table tableName="%">
            <generatedKey column="id" sqlStatement="mysql"></generatedKey>
        </table>
    </context>

</generatorConfiguration>

```

## Java 方式生成

### pom.xml 配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>top.simba1949</groupId>
    <artifactId>Generator-Java</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.4.1</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis.generator</groupId>
            <artifactId>mybatis-generator-core</artifactId>
            <version>1.3.7</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.40</version>
        </dependency>
    </dependencies>
</project>
```

### generatorConfig.xml 配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
<generatorConfiguration>
    <context id="mysql" defaultModelType="flat" targetRuntime="MyBatis3Simple">
        <!-- 生成的Java文件的编码 -->
        <property name="javaFileEncoding" value="UTF-8" />
        <!-- 格式化java代码 -->
        <property name="javaFormatter" value="org.mybatis.generator.api.dom.DefaultJavaFormatter" />
        <!-- 格式化XML代码 -->
        <property name="xmlFormatter" value="org.mybatis.generator.api.dom.DefaultXmlFormatter" />
        <!--添加分隔符-->
        <property name="beginningDelimiter" value="'"></property>
        <property name="endingDelimiter" value="'"></property>
        <!--生成注释信息的配置-->
        <commentGenerator>
            <property name="suppressDate" value="true"></property>
            <property name="addRemarkComments" value="true"></property>
        </commentGenerator>
        <!--数据库连接信息-->
        <jdbcConnection
                driverClass="com.mysql.jdbc.Driver"
                connectionURL="jdbc:mysql://localhost:3306/mybatis"
                userId="root"
                password="19491001">
        </jdbcConnection>
        <!--生成实体类的配置-->
        <javaModelGenerator targetPackage="top.simba1949.common" targetProject="F:/java">
        </javaModelGenerator>
        <!--生成mapper.xml的配置-->
        <sqlMapGenerator targetPackage="top.simba1949.mapper" targetProject="F:/java"></sqlMapGenerator>
        <!--生成mapper接口的配置-->
        <javaClientGenerator type="XMLMAPPER" targetPackage="top.simba1949.mapper" targetProject="F:/java"></javaClientGenerator>
        <!--表的配置-->
        <table tableName="%">
            <generatedKey column="id" sqlStatement="mysql"></generatedKey>
        </table>
    </context>

</generatorConfiguration>
```

### GeneratorMain.java 配置

```java
package top.simba1949.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author simba@onlying.cn
 * @date 2018/8/7 9:57
 */
public class GeneratorMain {
    public static void main(String[] args) throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        ArrayList<String> warnings = new ArrayList<String>();
        boolean overWrite = true;

        String path = GeneratorMain.class.getClassLoader().getResource("").getPath();
        File configFile = new File(path + "/generatorConfig.xml");

        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);

        DefaultShellCallback callback = new DefaultShellCallback(overWrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
}
```

## Maven 方式生成

### pom.xml 配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>top.simba1949</groupId>
    <artifactId>Generator-Maven</artifactId>
    <version>1.0-SNAPSHOT</version>

    <build>
        <plugins>
            <plugin>
                <groupId>org.mybatis.generator</groupId>
                <artifactId>mybatis-generator-maven-plugin</artifactId>
                <version>1.3.7</version>
                <configuration>
	                <!--指定代码生成器配置文件-->
	                <configurationFile>./src/main/resources/generatorConfig.xml</configurationFile>
                    <verbose>true</verbose>
                    <overwrite>true</overwrite>
                </configuration>
                <dependencies>
                    <!--配置数据库驱动-->
                    <dependency>
                        <groupId>mysql</groupId>
                        <artifactId>mysql-connector-java</artifactId>
                        <version>5.1.40</version>
                    </dependency>
                </dependencies>
                <executions>
                    <execution>
                        <id>Generate MyBatis Artifacts</id>
                        <goals>
                            <goal>generate</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>
```

### generatorConfig.xml 配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
<generatorConfiguration>
    <context id="mysql" defaultModelType="flat" targetRuntime="MyBatis3Simple">
        <!-- 生成的Java文件的编码 -->
        <property name="javaFileEncoding" value="UTF-8" />
        <!-- 格式化java代码 -->
        <property name="javaFormatter" value="org.mybatis.generator.api.dom.DefaultJavaFormatter" />
        <!-- 格式化XML代码 -->
        <property name="xmlFormatter" value="org.mybatis.generator.api.dom.DefaultXmlFormatter" />
        <!--添加分隔符-->
        <property name="beginningDelimiter" value="'"></property>
        <property name="endingDelimiter" value="'"></property>
        <!--生成注释信息的配置-->
        <commentGenerator>
            <property name="suppressDate" value="true"></property>
            <property name="addRemarkComments" value="true"></property>
        </commentGenerator>
        <!--数据库连接信息-->
        <jdbcConnection
                driverClass="com.mysql.jdbc.Driver"
                connectionURL="jdbc:mysql://localhost:3306/mybatis"
                userId="root"
                password="19491001">
        </jdbcConnection>
        <!--生成实体类的配置-->
        <javaModelGenerator targetPackage="top.simba1949.common" targetProject="F:/java">
        </javaModelGenerator>
        <!--生成mapper.xml的配置-->
        <sqlMapGenerator targetPackage="top.simba1949.mapper" targetProject="F:/java"></sqlMapGenerator>
        <!--生成mapper接口的配置-->
        <javaClientGenerator type="XMLMAPPER" targetPackage="top.simba1949.mapper" targetProject="F:/java"></javaClientGenerator>
        <!--表的配置-->
        <table tableName="%">
            <generatedKey column="id" sqlStatement="mysql"></generatedKey>
        </table>
    </context>

</generatorConfiguration>
```

### 运行

使用 mvn compile 或者 mvn test 或者 mvn package 或者 mvn install 

或者 插件中 mybatis-gennerator:generate 即可生成

## 命令方式

### generatorConfig.xml 配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
<generatorConfiguration>
    <!--指定数据库驱动路径-->
    <classPathEntry location="./mysql-connector-java-5.1.40.jar"/>
    <context id="mysql" defaultModelType="flat" targetRuntime="MyBatis3Simple">
        <!-- 生成的Java文件的编码 -->
        <property name="javaFileEncoding" value="UTF-8" />
        <!-- 格式化java代码 -->
        <property name="javaFormatter" value="org.mybatis.generator.api.dom.DefaultJavaFormatter" />
        <!-- 格式化XML代码 -->
        <property name="xmlFormatter" value="org.mybatis.generator.api.dom.DefaultXmlFormatter" />
        <!--添加分隔符-->
        <property name="beginningDelimiter" value="'"></property>
        <property name="endingDelimiter" value="'"></property>
        <!--生成注释信息的配置-->
        <commentGenerator>
            <property name="suppressDate" value="true"></property>
            <property name="addRemarkComments" value="true"></property>
        </commentGenerator>
        <!--数据库连接信息-->
        <jdbcConnection
                driverClass="com.mysql.jdbc.Driver"
                connectionURL="jdbc:mysql://localhost:3306/mybatis"
                userId="root"
                password="19491001">
        </jdbcConnection>
        <!--生成实体类的配置-->
        <javaModelGenerator targetPackage="top.simba1949.common" targetProject="F:/Java">
        </javaModelGenerator>
        <!--生成mapper.xml的配置-->
        <sqlMapGenerator targetPackage="top.simba1949.mapper" targetProject="F:/Java"></sqlMapGenerator>
        <!--生成mapper接口的配置-->
        <javaClientGenerator type="XMLMAPPER" targetPackage="top.simba1949.mapper" targetProject="F:/Java"></javaClientGenerator>
        <!--表的配置-->
        <table tableName="%">
            <generatedKey column="id" sqlStatement="mysql"></generatedKey>
        </table>
    </context>

</generatorConfiguration>
```

### 命令如下

在终端下使用，需要制定 mybatis-generator-core-1.3.7.jar 和 mysql-connector-java-5.1.40.jar 的位置

```
java -jar mybatis-generator-core-1.3.7.jar -configfile generatorConfig.xml
```

