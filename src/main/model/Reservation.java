package main.model;

import java.sql.Date;

/**
 * Created by Gize on 4/19/2017.
 */
public class Reservation {
    private  String code;
    private Date checkInDate;
    private  Date bookedDate;
    private  Date checkOut;
    private  String guest;
    private  String room;
    private  String registrationStatus;

    public void setCode(String code) {
        this.code = code;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setBookedDate(Date bookedDate) {
        this.bookedDate = bookedDate;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus;
    }



    public String getCode() {
        return code;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getBookedDate() {
        return bookedDate;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public String getGuest() {
        return guest;
    }

    public String getRoom() {
        return room;
    }

    public String getRegistrationStatus() {
        return registrationStatus;
    }


}
