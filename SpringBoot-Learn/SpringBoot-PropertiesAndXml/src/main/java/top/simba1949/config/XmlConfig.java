package top.simba1949.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @ImportResource("classpath:xml/bean.xml") 使用 @ImportResource 即可导入 xml 配置文件
 *
 * @author simba1949@outlook.com
 * @date 2018/10/13 13:21
 */
@Configuration
@ImportResource("classpath:xml/bean.xml")
public class XmlConfig {
}
