package top.simba1949.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/21 15:57
 */
@Controller
public class HelloWorldController {

    @GetMapping()
    public String index(){
        return "Index";
    }

    @GetMapping("/say")
    public String sayHello(HttpServletRequest request){
        request.getSession().setAttribute("say","Welcome To JSP");
        return "Hello";
    }
}
