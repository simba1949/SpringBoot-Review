package top.simba1949.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author simba1949@outlook.com
 * @date 2018/10/19 23:45
 */
@Component
public class StringBean {

    @Value("${ordinary.string}")
    private String ordinaryString;

    public void setOrdinaryString(String ordinaryString) {
        this.ordinaryString = ordinaryString;
    }

    public String getOrdinaryString() {
        return ordinaryString;
    }
}
