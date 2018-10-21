package top.simba1949.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/20 15:33
 */
@Configuration
@ImportResource(locations = "classpath*:applicationContext-mybatis.xml")
public class MybatisConfig {
}
