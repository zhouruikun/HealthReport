/**
 * <h3>HealthReport</h3>
 * <p></p>
 *
 * @author : ZhouKun
 * @date : 2020-03-19 11:27
 **/
public class LoginModel {
    String mobile;
    String password;

    public LoginModel(String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
