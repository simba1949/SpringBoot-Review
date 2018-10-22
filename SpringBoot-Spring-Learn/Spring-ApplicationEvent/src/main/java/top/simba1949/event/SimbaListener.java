package top.simba1949.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 自定义监听事件，实现 ApplicationListener<要监听的事件>，实现监听后的业务逻辑
 *
 * @author simba1949@outlook.com
 * @date 2018/10/22 19:39
 */
@Component
public class SimbaListener implements ApplicationListener<SimbaEvent> {

    @Override
    public void onApplicationEvent(SimbaEvent event) {
        String msg = event.getMsg();
        System.err.println("SimbaListener 监听器监听到的消息是" + msg);
    }
}
