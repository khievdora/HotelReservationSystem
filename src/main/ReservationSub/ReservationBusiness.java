package main.ReservationSub;

import main.model.Reservation;

/**
 * Created by Gize on 4/19/2017.
 */
public class ReservationBusiness {
    private ReservationService checkIn;
    private ReservationService waiting;
    private ReservationService confirmed;
    private ReservationService currentStatus;

    public ReservationBusiness(String status) {
        if (status.equals("Check In")) {
            currentStatus = new CheckInReservation(this);

        } else if (status.equals("Confirmed")) {
            currentStatus = new ConfirmedReservation(this);

        } else {
            currentStatus = new WaitingReservation(this);

        }
    }

    public void reserve(Reservation obj) {
        currentStatus.reserve(obj);

    }

    public void validate() {
        //TODO: call controller method that validates

    }

    public void provideQuantee(){
        //TODO: call controller method that provides quarantee

    }

    public void save(Reservation obj) {
        //TODO: call controller method that saves to the database

    }

    public ReservationService getCurrentStatus() {
        return currentStatus;
    }

    public ReservationService getCheckIn() {
        return checkIn;
    }

    public ReservationService getWaiting() {
        return waiting;
    }

    public ReservationService getConfirmed() {
        return confirmed;
    }
}
