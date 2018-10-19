package top.simba1949.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.simba1949.el.ElExpression;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/19 23:56
 */
@RestController
public class HelloWorldController {

    @Autowired
    private ElExpression elExpression;

    @GetMapping("/el")
    public String testEl(){
        elExpression.print();
        return "EL";
    }
}
