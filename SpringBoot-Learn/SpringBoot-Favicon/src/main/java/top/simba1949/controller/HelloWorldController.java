package top.simba1949.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/13 16:33
 */
@RestController
public class HelloWorldController {

    @GetMapping("say")
    public String sayHello(){
        return "Hello World!";
    }
}
