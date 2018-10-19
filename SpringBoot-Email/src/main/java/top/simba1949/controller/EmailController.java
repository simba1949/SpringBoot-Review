package top.simba1949.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.simba1949.service.IEmailService;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/19 22:18
 */
@RestController
public class EmailController {

    @Autowired
    private IEmailService iEmailService;

    @RequestMapping("/send")
    public String sendEmail(String receiver){
        try {
            String title = "使用 SpringBoot 发送邮件测试";
            String context = "这是使用 SpringBoot 发送测试邮件的测试内容";

            iEmailService.sendSimpleMail(receiver, title, context);

            return "发送测试邮件成功";
        } catch (Exception e){
            return e.getMessage();
        }
    }

    @GetMapping("/say")
    public String sayHello(){
        return "Hello World";
    }
}
