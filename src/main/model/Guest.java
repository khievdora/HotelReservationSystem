package main.model;

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
    private  StringProperty address;
    private  StringProperty phone;

    public Guest(String code, String fName, String mName, String lName, String idCard, String passport, String address, String phone) {
        this.code = new SimpleStringProperty(code);
        this.fName = new SimpleStringProperty(code);
        this.mName = new SimpleStringProperty(code);
        this.lName = new SimpleStringProperty(code);
        this.idCard = new SimpleStringProperty(code);
        this.passport = new SimpleStringProperty(code);
        this.address = new SimpleStringProperty(code);
        this.phone = new SimpleStringProperty(code);
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

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
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
}
