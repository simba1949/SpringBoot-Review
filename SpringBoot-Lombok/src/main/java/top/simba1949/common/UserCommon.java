package top.simba1949.common;

import lombok.Data;

import java.util.Date;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/17 15:22
 */
@Data
public class UserCommon {
    private String username;
    private Integer sex;
    private Date birthday;
}
