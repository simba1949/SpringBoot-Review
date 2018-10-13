package top.simba1949.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @ConfigurationProperties(prefix = "author") 设置属性的前缀
 *
 * @author simba1949@outlook.com
 * @date 2018/10/13 11:57
 */
@Validated
@RestController
@ConfigurationProperties(prefix = "author")
public class HelloWorldController {

    private String username;
    private String motto;
    @Value("${author.address}")
    private String authorAddress;

    @RequestMapping("/author")
    public String getAuthorInfo(){
        return username + motto + authorAddress;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }
}
