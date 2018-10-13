package top.simba1949.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ControllerAdvice 声明这是一个全局处理中心
 *
 * @author simba1949@outlook.com
 * @date 2018/10/13 20:48
 */
@ControllerAdvice
public class GlobalExceptionCenter {
    /**
     * @ExceptionHandler(value = Exception.class) 声明下面这个方法处理哪类异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String dealWithException(Exception e){
        System.out.println(e.getMessage());
        return "网络异常";
    }
}
