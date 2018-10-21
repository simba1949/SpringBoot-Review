package top.simba1949.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import top.simba1949.Application;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/21 17:10
 */
public class ServletInit extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // Application.class 指的是该项目的启动类
        return builder.sources(Application.class);
    }
}
