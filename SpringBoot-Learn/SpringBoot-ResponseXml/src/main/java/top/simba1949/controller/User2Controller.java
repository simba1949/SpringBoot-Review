package top.simba1949.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.simba1949.common.UserCommon;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/13 22:03
 */
@RestController
public class User2Controller {

    /**
     * 在 SpringBoot 应用中，任何 @RestController 默认渲染为JSON响应
     * 请求方式中可以设置produces = "application/json"，也可不设置
     * @return
     */
    @GetMapping(value = "/getPage", produces = "application/json")
    public List<UserCommon> getPage(){
        List<UserCommon> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            UserCommon userCommon = new UserCommon();
            userCommon.setUsername("杜甫" + i);
            userCommon.setAge(i);
            userCommon.setBirthday(new Date());
            list.add(userCommon);
        }
        return list;
    }
}
