package top.simba1949.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author v_jiayytian@tencent.com
 * @date 2018/10/17 16:09
 */
@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String string(){
        return "Hello World!!!";
    }
}
