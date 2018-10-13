package top.simba1949.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/13 17:14
 */
@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @GetMapping("/say")
    public String sayHello(){
        System.out.println("hello");
        return "Hello World!!!";
    }
}
