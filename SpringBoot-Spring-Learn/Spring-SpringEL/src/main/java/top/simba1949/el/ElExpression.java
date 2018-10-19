package top.simba1949.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/19 23:35
 */
@Component
public class ElExpression {

    /**
     * 注入一个普通的字符串
     */
    @Value("注入一个普通的字符串")
    private String ordinaryString;
    /**
     * 从配置文件注入一个字符串
     */
    @Value("${ordinary.string}")
    private String configString;
    /**
     * 注入操作系统的属性
     */
    @Value("#{ systemProperties['os.name']}")
    private String osName;
    /**
     * 注入运算表达式的结果
     */
    @Value("#{ T(Math).random()}")
    private Double randomNumber;
    /**
     * 注入 Spring 容器中 Bean 的属性
     */
    @Value("#{stringBean.ordinaryString}")
    private String beanProperty;
    /**
     * 注入文件
     */
    @Value("classpath:config/file.properties")
    private Resource fileResource;

    /**
     * 注入网址内容
     */
    @Value("https://www.baidu.com")
    private Resource urlResource;

    public void print(){
        System.out.println("注入一个普通的字符串===" + ordinaryString);
        System.err.println("从配置文件注入一个字符串===" + configString);
        System.out.println("注入操作系统的属性" + osName);
        System.err.println("注入运算表达式的结果===" + randomNumber);
        System.out.println("注入 Spring 容器中 Bean 的属性===" + beanProperty);
        System.err.println("注入文件===" + fileResource);
        System.out.println("注入网址内容===" + urlResource);
    }

}
