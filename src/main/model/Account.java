package main.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Gize on 4/19/2017.
 */
public class Account {
    private  IntegerProperty code;
    private  StringProperty userName;
    private  StringProperty password;
    private  StringProperty status;
    private  StringProperty userRole;
    private  StringProperty accountStatus;

    public Account(){
        this.code = new SimpleIntegerProperty();
        this.userName = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
        this.status = new SimpleStringProperty();
        this.userRole = new SimpleStringProperty();
        this.accountStatus = new SimpleStringProperty();
    }

    public int getCode() {
        return code.get();
    }

    public IntegerProperty codeProperty() {
        return code;
    }

    public void setCode(int code) {
        this.code.set(code);
    }

    public String getUserName() {
        return userName.get();
    }

    public StringProperty userNameProperty() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getUserRole() {
        return userRole.get();
    }

    public StringProperty userRoleProperty() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole.set(userRole);
    }

    public String getAccountStatus() {
        return accountStatus.get();
    }

    public StringProperty accountStatusProperty() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus.set(accountStatus);
    }

    @Override
    public String toString() {
        return "Account{" +
                "code=" + code +
                ", userName=" + userName +
                ", password=" + password +
                ", status=" + status +
                ", userRole=" + userRole +
                ", accountStatus=" + accountStatus +
                '}';
    }
}