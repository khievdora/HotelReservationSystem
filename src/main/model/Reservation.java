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
