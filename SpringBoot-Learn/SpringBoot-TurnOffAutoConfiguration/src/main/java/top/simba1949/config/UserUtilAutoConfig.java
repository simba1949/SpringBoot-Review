package top.simba1949.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @EnableAutoConfiguration 开启自动配置
 *
 * @author simba1949@outlook.com
 * @date 2018/10/13 10:28
 */
@EnableAutoConfiguration
public class UserUtilAutoConfig {

    @Bean
    public UserConfig userConfig(){
        return new UserConfig();
    }
}
