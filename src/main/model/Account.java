package main.model;

/**
 * Created by Gize on 4/19/2017.
 */
public class Account {
    private  String code;
    private  String userName;
    private  String password;
    private  String status;
    private  String userRole;
    private  String accountStatus;

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    public String getUserRole() {
        return userRole;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public String getCode() {

        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }
}
