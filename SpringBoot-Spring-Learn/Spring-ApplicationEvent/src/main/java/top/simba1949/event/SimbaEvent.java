package top.simba1949.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件，需要继承 ApplicationEvent
 *
 * @author simba1949@outlook.com
 * @date 2018/10/22 19:37
 */
@Data
public class SimbaEvent extends ApplicationEvent {

    private String msg;
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public SimbaEvent(Object source) {
        super(source);
    }

    public SimbaEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }
}
