package java.model;

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

    private  String country;
}
