package main.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Gize on 4/19/2017.
 */
public class Package {
    private StringProperty code;
    private StringProperty name;
    private StringProperty price;
    private StringProperty reservation;

    public Package(String code, String name, String price, String reservation) {
        this.code = new SimpleStringProperty(code);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleStringProperty(price);
        this.reservation = new SimpleStringProperty(reservation);
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }
}
