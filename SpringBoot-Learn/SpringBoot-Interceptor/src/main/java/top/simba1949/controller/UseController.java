package top.simba1949.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/13 17:25
 */
@RestController
@RequestMapping("/use")
public class UseController {

    @RequestMapping("/str")
    public String getString(){
        return "君不见黄河之水天上来";
    }

    @RequestMapping("/int")
    public int getInteger(){
        return 1;
    }
}
