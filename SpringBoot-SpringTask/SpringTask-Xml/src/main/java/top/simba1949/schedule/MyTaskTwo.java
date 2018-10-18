package top.simba1949.schedule;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author v_jiayytian@tencent.com
 * @date 2018/10/18 14:32
 */
@Component
public class MyTaskTwo {

    public void doTask(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(format.format(new Date()));
    }
}
