package main.ReservationSub.ReservationServiceProvider;

import main.dbconnection.DataAccessFacade;
import main.dbsub.ReservationImpl;
import main.model.Reservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gize on 4/20/2017.
 */
public class ResServiceImplementation implements ResServiceProvider {


    @Override
    public boolean addReservation(Reservation res) {
        ReservationImpl impl = new ReservationImpl();
        return impl.saveReservation(res);
    }

    @Override
    public boolean editReservation(Reservation res) {
        return false;
    }

    @Override
    public List<Reservation> getAllReservation() {
        ReservationImpl impl = new ReservationImpl();
        return impl.getAllReservation();
    }

    @Override
    public Reservation getReservatinById(String id) {
        ReservationImpl impl = new ReservationImpl();
        return impl.getReservatinById(id);
    }

    @Override
    public boolean deleteAllReservation() {
        ReservationImpl impl = new ReservationImpl();
        return impl.deleteAllReservation();
    }

    @Override
    public boolean deleteReservationById(String id) {
        ReservationImpl impl = new ReservationImpl();
        return impl.deleteReservationById(id);
    }
}
