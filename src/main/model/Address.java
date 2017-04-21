package main.model;

/**
 * Created by Gize on 4/19/2017.
 */
public class Address {
    private  String code;
    private  String zip;
    private  String street;
    private  String city;
    private  String state;

    public String getCode() {
        return code;
    }

    public String getZip() {
        return zip;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private  String country;
}
