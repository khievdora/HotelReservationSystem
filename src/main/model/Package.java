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
}
