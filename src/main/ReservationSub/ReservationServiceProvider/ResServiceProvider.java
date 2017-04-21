package main.ReservationSub.ReservationServiceProvider;

import main.model.Reservation;

import java.util.List;

/**
 * Created by Gize on 4/20/2017.
 */
public interface ResServiceProvider {
   boolean addReservation(Reservation res);
   boolean editReservation(Reservation res);
   List<Reservation> getAllReservation();
   Reservation getReservatinById(String id);
   boolean deleteAllReservation();
   boolean deleteReservationById(String id);
}
