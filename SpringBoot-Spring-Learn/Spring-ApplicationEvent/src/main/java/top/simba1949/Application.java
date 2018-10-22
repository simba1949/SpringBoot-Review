package top.simba1949;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.simba1949.config.EventConfig;
import top.simba1949.event.SimbaPublisher;

/**
 * 主类，发布事件的开始
 *
 * @author simba1949@outlook.com
 * @date 2018/10/22 19:37
 */
public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
        SimbaPublisher bean = context.getBean(SimbaPublisher.class);
        bean.publish("Welcome To SpringApplicationEvent");
        context.close();
    }
}
