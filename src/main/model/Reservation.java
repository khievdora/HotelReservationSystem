package main.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Date;

/**
 * Created by Gize on 4/19/2017.
 */
public class Reservation {
    private IntegerProperty code;
    private  Date checkInDate;
    private  Date checkOut;
    private  Date bookedDate;
    private  StringProperty guest;
    private  StringProperty room;
    private  StringProperty registrationStatus;

    public Reservation() {
        this.code = new SimpleIntegerProperty();
        this.guest = new SimpleStringProperty();
        this.room = new SimpleStringProperty();
        this.registrationStatus = new SimpleStringProperty();
    }

    public Reservation(int code, Date checkInDate, Date bookedDate, Date checkOut, String guest, String room, String registrationStatus) {
        this.code = new SimpleIntegerProperty(code);
        this.checkInDate = checkInDate;
        this.bookedDate = bookedDate;
        this.checkOut = checkOut;
        this.guest = new SimpleStringProperty(guest);
        this.room = new SimpleStringProperty(room);
        this.registrationStatus = new SimpleStringProperty(registrationStatus);
    }

    public IntegerProperty getCode() {
        return code;
    }

    public IntegerProperty codeProperty() {
        return code;
    }

    public void setCode(int code) {
        this.code.set(code);
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Date getBookedDate() {
        return bookedDate;
    }

    public void setBookedDate(Date bookedDate) {
        this.bookedDate = bookedDate;
    }

    public String getGuest() {
        return guest.get();
    }

    public StringProperty guestProperty() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest.set(guest);
    }

    public String getRoom() {
        return room.get();
    }

    public StringProperty roomProperty() {
        return room;
    }

    public void setRoom(String room) {
        this.room.set(room);
    }

    public String getRegistrationStatus() {
        return registrationStatus.get();
    }

    public StringProperty registrationStatusProperty() {
        return registrationStatus;
    }

    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus.set(registrationStatus);
    }
}
