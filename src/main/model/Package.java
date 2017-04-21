package main.model;

/**
 * Created by Gize on 4/19/2017.
 */
public class Package {
    private String code;
    private String name;
    private String price;
    private String reservation;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getReservation() {
        return reservation;
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
