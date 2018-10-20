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
