package main.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Date;

/**
 * Created by Gize on 4/19/2017.
 */
public class Reservation {
    private  StringProperty code;
    private  Date checkInDate;
    private  Date bookedDate;
    private  Date checkOut;
    private  StringProperty guest;
    private  StringProperty room;
    private  StringProperty registrationStatus;

    public Reservation(String code, Date checkInDate, Date bookedDate, Date checkOut, String guest, String room, String registrationStatus) {
        this.code = new SimpleStringProperty(code);
        this.checkInDate = checkInDate;
        this.bookedDate = bookedDate;
        this.checkOut = checkOut;
        this.guest = new SimpleStringProperty(guest);
        this.room = new SimpleStringProperty(room);
        this.registrationStatus = new SimpleStringProperty(registrationStatus);
    }
}
