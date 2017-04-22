package main.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Date;

/**
 * Created by Gize on 4/19/2017.
 */
public class Reservation {
    private  String code;
    private  Date checkInDate;
    private  Date checkOut;
    private  Date bookedDate;
    private  String guest;
    private  String room;
    private  String registrationStatus;

    public Reservation() {
    }

    public Reservation(String code, Date checkInDate, Date bookedDate, Date checkOut, String guest, String room, String registrationStatus) {
        this.code = code;
        this.checkInDate = checkInDate;
        this.bookedDate = bookedDate;
        this.checkOut = checkOut;
        this.guest = guest;
        this.room = room;
        this.registrationStatus = registrationStatus;
    }

    public String getCode() {
        return code;
    }

    public String codeProperty() {
        return code;
    }

    public void setCode(String code) {
        this.code=code;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getBookedDate() {
        return bookedDate;
    }

    public void setBookedDate(Date bookedDate) {
        this.bookedDate = bookedDate;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public String getGuest() {
        return guest;
    }

    public String guestProperty() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest=guest;
    }

    public String getRoom() {
        return room;
    }

    public String roomProperty() {
        return room;
    }

    public void setRoom(String room) {
        this.room=room;
    }

    public String getRegistrationStatus() {
        return registrationStatus;
    }

    public String registrationStatusProperty() {
        return registrationStatus;
    }

    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus=(registrationStatus);
    }
}
