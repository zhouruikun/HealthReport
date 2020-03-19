/**
 * <h3>HealthReport</h3>
 * <p></p>
 *
 * @author : ZhouKun
 * @date : 2020-03-19 12:11
 **/
public class LoginResModel {
    class Result{
        String userName;
                 String  firstLogin;
                 String  id;
                 String  name;
                 String  mobile;
                 String  loginName;
                 String  token;
                 String  loginDate;
                 String  key;
        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getFirstLogin() {
            return firstLogin;
        }


        public void setFirstLogin(String firstLogin) {
            this.firstLogin = firstLogin;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getLoginDate() {
            return loginDate;
        }

        public void setLoginDate(String loginDate) {
            this.loginDate = loginDate;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }
    String  description;
    String  code;
    Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
