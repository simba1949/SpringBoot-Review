package top.simba1949.common;

import java.util.Date;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/13 21:45
 */
public class UserCommon {
    private String username;
    private Integer age;
    private Date birthday;

    @Override
    public String toString() {
        return "UserCommon{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
