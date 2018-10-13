package top.simba1949.config;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/13 10:46
 */
public class UserConfig {

    private String username = "simba1949";

    @Override
    public String toString() {
        return "UserConfig{" +
                "username='" + username + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
