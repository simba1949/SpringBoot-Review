package top.simba1949.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.simba1949.properties.UseProperties;

import java.io.IOException;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/13 12:41
 */
@RestController
public class UseController {

    @Autowired
    private UseProperties useProperties;

    @RequestMapping("/property")
    public String getString(){
        return useProperties.string();
    }

    @RequestMapping("/file1")
    public String filename1() throws IOException {
        return useProperties.getFile1();
    }

    @RequestMapping("/file2")
    public String filename2() throws IOException {
        return useProperties.getFile2();
    }

    @RequestMapping("/env")
    public String environment(){
        return useProperties.getContextByEnvironment();
    }
}
