package main.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Gize on 4/19/2017.
 */
public class Guest {
    private  String code;
    private  String fName;
    private  String mName;
    private  String lName;
    private  String idCard;
    private  String passport;
    private  String address;
    private  String phone;

    public Guest(String code, String fName, String mName, String lName, String idCard, String passport, String address, String phone) {
        this.code = (code);
        this.fName = (fName);
        this.mName = (mName);
        this.lName = (lName);
        this.idCard = (idCard);
        this.passport = (passport);
        this.address = address;
        this.phone = (phone);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "code=" + code +
                ", fName=" + fName +
                ", mName=" + mName +
                ", lName=" + lName +
                ", idCard=" + idCard +
                ", passport=" + passport +
                ", address=" + address +
                ", phone=" + phone +
                '}';
    }
}
