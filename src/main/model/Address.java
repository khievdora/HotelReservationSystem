package main.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Gize on 4/19/2017.
 */
public class Address {
    private  StringProperty code;
    private  StringProperty zip;
    private  StringProperty street;
    private  StringProperty city;
    private  StringProperty state;
    private  StringProperty country;

    public Address(String code, String zip, String street, String city, String state, String country) {
        this.code = new SimpleStringProperty(code);
        this.zip = new SimpleStringProperty(zip);
        this.street = new SimpleStringProperty(street);
        this.city = new SimpleStringProperty(city);
        this.state = new SimpleStringProperty(state);
        this.country = new SimpleStringProperty(country);
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

    public String getZip() {
        return zip.get();
    }

    public StringProperty zipProperty() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip.set(zip);
    }

    public String getStreet() {
        return street.get();
    }

    public StringProperty streetProperty() {
        return street;
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getState() {
        return state.get();
    }

    public StringProperty stateProperty() {
        return state;
    }

    public void setState(String state) {
        this.state.set(state);
    }

    public String getCountry() {
        return country.get();
    }

    public StringProperty countryProperty() {
        return country;
    }

    public void setCountry(String country) {
        this.country.set(country);
    }
}
