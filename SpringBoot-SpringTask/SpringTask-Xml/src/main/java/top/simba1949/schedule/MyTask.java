package top.simba1949.schedule;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/18 11:29
 */
@Component
public class MyTask {

    public void doTask(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(format.format(new Date()));
    }
}
