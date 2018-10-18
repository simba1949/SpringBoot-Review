package top.simba1949.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author v_jiayytian@tencent.com
 * @date 2018/10/18 14:47
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/say")
    public String sayHello(){
        return "Hello World";
    }
}
