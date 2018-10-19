package top.simba1949.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/17 15:10
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/say")
    public String sayHello(){
        return "Hello World!";
    }

    @RequestMapping("/name/{name}")
    public String returnName(@PathVariable String name){
        return "Tony:" + name;
    }
}
