package top.simba1949.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/18 11:29
 */
@Component
public class MyTask {
    /**
     * @Scheduled(cron = "0/5 * * * * ?") 七子表达式
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void doTask(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(format.format(new Date()));
    }
}
