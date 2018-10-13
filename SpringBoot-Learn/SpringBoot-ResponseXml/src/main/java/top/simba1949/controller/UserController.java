package top.simba1949.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.simba1949.common.UserCommon;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/13 21:46
 */
@RestController
public class UserController {
    /**
     * 请求方式中需要设置 produces = "application/xml"
     * @return
     */
    @GetMapping(value = "/getUserList", produces = "application/xml")
    public List<UserCommon> getUserList(){
        List<UserCommon> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            UserCommon userCommon = new UserCommon();
            userCommon.setUsername("李白" + i);
            userCommon.setAge(i);
            userCommon.setBirthday(new Date());
            list.add(userCommon);
        }
        return list;
    }
}
