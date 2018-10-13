package top.simba1949.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/13 20:48
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/say")
    public String sayHello(){
        int i = 1 / 0;
        return "Hello World!!!";
    }
}
