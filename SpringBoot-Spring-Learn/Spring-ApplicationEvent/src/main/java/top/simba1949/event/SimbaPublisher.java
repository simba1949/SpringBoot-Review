package top.simba1949.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 用于发布事件
 *
 * @author simba1949@outlook.com
 * @date 2018/10/22 19:45
 */
@Component
public class SimbaPublisher {

    @Autowired
    ApplicationContext applicationContext;

    public void publish(String msg){
        applicationContext.publishEvent(new SimbaEvent(this, msg));
    }
}
