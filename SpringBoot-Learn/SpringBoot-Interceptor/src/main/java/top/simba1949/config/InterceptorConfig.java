package top.simba1949.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.simba1949.interceptor.HelloWorldInterceptor;

/**
 * 注册拦截器
 *
 * @author simba1949@outlook.com
 * @date 2018/10/13 17:17
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    HelloWorldInterceptor helloWorldInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(helloWorldInterceptor).addPathPatterns("/hello/**");
    }
}
