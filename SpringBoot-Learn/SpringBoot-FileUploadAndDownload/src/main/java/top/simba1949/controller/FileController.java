package top.simba1949.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/13 22:24
 */@RestController
public class FileController {

     @RequestMapping("/file")
    public String upload(@RequestParam(value = "file")MultipartFile file, HttpServletRequest request) throws IOException {
         // 获取 upload 目录，不存在就创建
         // 获取当前当前项目目录
         String path = FileController.class.getResource("/").getPath();
         String realPath = path.substring(1);
         File directory = new File(realPath + "upload/");
         if (!directory.exists()){
             directory.mkdirs();
         }
         // 将上传的文件写入到磁盘中
         file.transferTo(new File(directory + "/" + file.getOriginalFilename()));
         // 返回可以访问的路径
         return "http://localhost:8080/upload/" + file.getOriginalFilename();
    }
}
