package main.model;

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

    public String getCode() {
        return code;
    }

    public String getfName() {
        return fName;
    }

    public String getmName() {
        return mName;
    }

    public String getlName() {
        return lName;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getPassport() {
        return passport;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
