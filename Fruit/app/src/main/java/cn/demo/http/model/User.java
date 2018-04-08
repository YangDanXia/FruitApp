package cn.demo.http.model;

public class User {

    private String username;
    private String password;
    private String userPhone;
    private String userAddress;
    private String userIntegration;
    private String userName;


    public String getUserId() {
        return username;
    }
    public void setUserId(String userId) {
        this.username = userId;
    }
    public String getUserPwd() {
        return password;
    }
    public void setUserPwd(String userPwd) {
        this.password = userPwd;
    }
    public String getUserPhone() {
        return userPhone;
    }
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    public String getUserAddress() {
        return userAddress;
    }
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
    public String getUserIntegration() {
        return userIntegration;
    }
    public void setUserIntegration(String userIntegration) {
        this.userIntegration = userIntegration;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

}
