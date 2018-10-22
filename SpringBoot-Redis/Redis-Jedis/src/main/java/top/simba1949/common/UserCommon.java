package top.simba1949.common;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/22 21:39
 */
@Data
public class UserCommon implements Serializable {

    private Integer id;
    private String username;
    private Date birthday;
}
