package top.simba1949.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import top.simba1949.service.IEmailService;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/19 22:23
 */
@Service
public class EmailServiceImpl implements IEmailService {

    @Value("${spring.mail.username}")
    private String sender;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendSimpleMail(String receiver, String title, String content) {
        // 创建邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        // 设置邮件发送人地址
        message.setFrom(sender);
        // 设置邮件接收人地址
        message.setTo(receiver);

        // 设置邮件标题
        message.setSubject(title);
        // 设置邮件内容
        message.setText(content);

        javaMailSender.send(message);
    }
}
