package top.simba1949.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @Validated 开启属性校验
 *
 * @author simba1949@outlook.com
 * @date 2018/10/13 12:17
 */
@Validated
@RestController
@ConfigurationProperties(prefix = "author")
public class PropertyValidationController {

    @NotNull
    private Integer age;

    public void setAge(Integer age) {
        this.age = age;
    }
}
