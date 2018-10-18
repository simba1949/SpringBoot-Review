package top.simba1949.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author v_jiayytian@tencent.com
 * @date 2018/10/18 15:16
 */
@Api(tags = "Hello World 测试接口")
@RestController
public class HelloWorldController {

    @ApiOperation(value = "用于方法描述", notes = "用于提示内容")
    @RequestMapping("/say/{data}")
    public String sayHello(@PathVariable String data){
        return "Hello World——" + data;
    }
}
