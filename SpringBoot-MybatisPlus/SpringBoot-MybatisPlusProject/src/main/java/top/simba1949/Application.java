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
