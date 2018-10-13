package top.simba1949.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.simba1949.config.UserConfig;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/13 10:24
 */
@RestController
@RequestMapping("/world")
public class HelloWorldController {

    @Autowired
    UserConfig userConfig;

    @RequestMapping("/str")
    public String getString(){
        return userConfig.toString();
    }
}
