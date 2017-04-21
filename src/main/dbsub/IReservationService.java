package main.dbsub;

import main.model.Reservation;

import java.util.List;

/**
 * Created by gebre on 4/21/2017.
 */
public interface IReservationService {
    public boolean saveReservation(Reservation reservation);
    public boolean updateReservation(Reservation reservation);
    public List<Reservation> getAllReservation();
    public Reservation getReservatinById(String idReservation);
    public boolean deleteAllReservation();
    public boolean deleteReservationById(String idReservation);
}
