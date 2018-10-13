package top.simba1949.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URL;

/**
 * 使用 @PropertySources() 导入配置文件，里面是 @PropertySource 的数组
 * @PropertySource value 表示properties 配置文件，encoding 表示配置文件的编码格式
 *
 * @author simba1949@outlook.com
 * @date 2018/10/13 12:29
 */
@PropertySources({
        @PropertySource(value = "classpath:properties/author.properties",encoding = "UTF-8"),
        @PropertySource(value = "classpath:properties/book.properties", encoding = "UTF-8")
})
@Component
public class UseProperties {
    @Value("${author.username}")
    private String username;
    @Value("${author.motto}")
    private String motto;
    @Value("${book.name}")
    private String name;
    @Value("${book.time}")
    private String time;
    /**
     * 可以获取文件的流的读写
     */
    @Value("classpath:properties/author.properties")
    private Resource resource;

    public String getFile1() throws IOException {
        String filename = resource.getFilename();
        URL url = resource.getURL();
        String description = resource.getDescription();
        URI uri = resource.getURI();
        return filename + "\n" + url + "\n" + description + "\n" + uri;
    }

    @Value("classpath:properties/book.properties")
    private Resource resource2;
    public String getFile2() throws IOException {
        String filename = resource2.getFilename();
        URL url = resource2.getURL();
        String description = resource2.getDescription();
        URI uri = resource2.getURI();

        return filename + "\n" + url + "\n" + description + "\n" + uri;
    }

    /**
     * environment 代表所有文件，
     * 可以通过 environment.getProperty("author.username") 获取属性值
     */
    @Autowired
    private Environment environment;

    public String getContextByEnvironment(){
        String authorUsername = environment.getProperty("author.username");
        String authorMotto = environment.getProperty("author.motto");
        String bookName = environment.getProperty("book.name");
        String bookTime = environment.getProperty("book.time");
        return  authorUsername + "\n" + authorMotto + "\n" + bookName + "\n" + bookTime;
    }

    public String string(){
        return username + "\n" + motto + "\n" + name + "\n" + time;
    }
}
