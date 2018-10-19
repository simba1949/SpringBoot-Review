package top.simba1949.service;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/19 22:21
 */
public interface IEmailService {
    /**
     * 发送简单邮件
     * @param receiver
     * @param title
     * @param content
     */
    void sendSimpleMail(String receiver, String title, String content);
}
