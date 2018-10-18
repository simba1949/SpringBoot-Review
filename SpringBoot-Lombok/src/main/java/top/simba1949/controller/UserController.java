package top.simba1949.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.simba1949.common.UserCommon;

import java.util.Date;

/**
 * @author v_jiayytian@tencent.com
 * @date 2018/10/17 15:21
 */
@RestController
public class UserController {

    @RequestMapping("/user")
    public UserCommon getUser(){
        UserCommon userCommon = new UserCommon();
        userCommon.setUsername("李白");
        userCommon.setSex(1);
        userCommon.setBirthday(new Date());
        return userCommon;
    }
}
