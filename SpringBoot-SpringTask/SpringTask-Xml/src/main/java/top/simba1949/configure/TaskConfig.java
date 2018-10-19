package top.simba1949.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/18 14:34
 */
@Configuration
@ImportResource(locations = "classpath:applicationContext-springTask.xml")
public class TaskConfig {
}
