package top.simba1949.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.simba1949.bean.UserBean;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/13 13:14
 */
@RestController
public class HelloWorldController {

    @Autowired
    private UserBean userBean;

    @RequestMapping("/say")
    public String say(){
        return userBean.userProviderString();
    }
}
