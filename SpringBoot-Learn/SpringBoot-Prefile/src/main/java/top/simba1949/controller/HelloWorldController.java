package top.simba1949.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/13 16:13
 */
@RestController
public class HelloWorldController {

    @GetMapping("/str")
    public String getString(){
        return "君不见黄河之水天上来";
    }
}
