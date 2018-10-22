# Springboot 集成 Jedis

## 前言

jedis maven 地址：https://mvnrepository.com/artifact/redis.clients/jedis

## 项目

### 在 pom.xml 添加依赖

```xml
<!-- https://mvnrepository.com/artifact/redis.clients/jedis -->
<dependency>
    <groupId>redis.clients</groupId>
    <artifactId>jedis</artifactId>
</dependency>
```

###  jedis 和连接池的使用

```
package top.simba1949.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import top.simba1949.common.UserCommon;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/22 21:39
 */
@Log
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 简单使用 jedis 客户端
     * @return
     */
    @PostMapping("jedis")
    public String setJedis(){
        // 获取 Redis 客户端，连接目标服务器
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // 使用 redis 语法
        jedis.set("jedis", "Jedis");
        // 关闭 redis 客户端
        jedis.close();
        return "设置成功";
    }

    @GetMapping("jedis")
    public String getJedis(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String str = jedis.get("jedis");
        return str;
    }

    @PostMapping("pool")
    public String setJedisPool(){
        // 获取 jedis 连接池配置文件对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 设置最大连接数
        jedisPoolConfig.setMaxTotal(20);
        // 设置最大空闲连接数
        jedisPoolConfig.setMaxIdle(10);

        // 创建 jedis 连接池
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379);
        // 从连接池中获取 jedis 对象
        Jedis jedis = jedisPool.getResource();
        List<UserCommon> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            UserCommon userCommon = new UserCommon();
            userCommon.setId(i);
            userCommon.setUsername("李白" + i);
            userCommon.setBirthday(new Date());
            list.add(userCommon);
        }
        // 序列化 list 对象
        jedis.set("list", JSON.toJSONString(list));
        return "设置成功";
    }

    @GetMapping("pool")
    public List<UserCommon> getJedisPool(){
        // 获取 jedis 连接池配置文件对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 设置最大连接数
        jedisPoolConfig.setMaxTotal(20);
        // 设置最大空闲连接数
        jedisPoolConfig.setMaxIdle(10);

        // 创建 jedis 连接池
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379);
        // 从连接池中获取 jedis 对象
        Jedis jedis = jedisPool.getResource();
        String list = jedis.get("list");
        // 反序列化对象
        JSONArray jsonArray = JSON.parseArray(list);
        List<UserCommon> userCommonList = jsonArray.toJavaList(UserCommon.class);
        return userCommonList;
    }
}
```