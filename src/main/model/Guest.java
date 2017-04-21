package main.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Gize on 4/19/2017.
 */
public class Guest {
    private  StringProperty code;
    private  StringProperty fName;
    private  StringProperty mName;
    private  StringProperty lName;
    private  StringProperty idCard;
    private  StringProperty passport;
    private  Address address;
    private  StringProperty phone;

    public Guest(String code, String fName, String mName, String lName, String idCard, String passport, Address address, String phone) {
        this.code = new SimpleStringProperty(code);
        this.fName = new SimpleStringProperty(fName);
        this.mName = new SimpleStringProperty(mName);
        this.lName = new SimpleStringProperty(lName);
        this.idCard = new SimpleStringProperty(idCard);
        this.passport = new SimpleStringProperty(passport);
        this.address = address;
        this.phone = new SimpleStringProperty(phone);
    }

    public String getCode() {
        return code.get();
    }

    public StringProperty codeProperty() {
        return code;
    }

    public void setCode(String code) {
        this.code.set(code);
    }

    public String getfName() {
        return fName.get();
    }

    public StringProperty fNameProperty() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName.set(fName);
    }

    public String getmName() {
        return mName.get();
    }

    public StringProperty mNameProperty() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName.set(mName);
    }

    public String getlName() {
        return lName.get();
    }

    public StringProperty lNameProperty() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName.set(lName);
    }

    public String getIdCard() {
        return idCard.get();
    }

    public StringProperty idCardProperty() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard.set(idCard);
    }

    public String getPassport() {
        return passport.get();
    }

    public StringProperty passportProperty() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport.set(passport);
    }

    public Address getAddress() {
        return address;
    }

    public Address addressProperty() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone.get();
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
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
