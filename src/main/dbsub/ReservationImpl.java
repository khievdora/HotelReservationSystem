package main.dbsub;
import main.model.Reservation;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gebre on 4/21/2017.
 */
public class ReservationImpl implements IReservation {
    private IDatabase iDatabase = null;

    public ReservationImpl() {
        iDatabase = Database.getInstance();
    }
    @Override
    public boolean saveReservation(Reservation reservation) {
        try{
            String query = "INSERT INTO reservation(idReservation, checkInDate, CheckOutDate, bookedDate, idGuest, isRoom,reservationStatus) " +
                    "VALUES('"+reservation.getCode() +
                    ",'"+reservation.getCheckInDate()+"'," +
                    "'"+reservation.getCheckOut()+"'," +
                    "'"+reservation.getBookedDate()+"'," +
                    "'"+reservation.getGuest()+"'" +
                    ",'"+reservation.getRoom()+"'," +
                    "'"+reservation.getRegistrationStatus()+"')";
            iDatabase.executeUpdate(query);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateReservation(Reservation reservation) {
        //idReservation, checkInDate, CheckOutDate, bookedDate, guest, room1,reservationStatus
        try{
            String query ="UPDATE reservation SET "+
                    "checkInDate='"+reservation.getCheckInDate()+"', " +
                    "CheckOutDate='"+reservation.getCheckOut()+"'," +
                    "bookedDate='"+reservation.getBookedDate()+"', " +
                    "idGuest='"+reservation.getGuest()+"', " +
                    "idRoom= '"+reservation.getRoom()+"'," +
                    "reservationStatus= '"+reservation.getRegistrationStatus()+"' " +
                    "WHERE idReservation=" + reservation.getCode();
            iDatabase.executeUpdate(query);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteReservationById(String idReservation) {
        try{
            String query = "DELETE FROM reservation WHERE idReservation='"+idReservation+"'";
            iDatabase.executeUpdate(query);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteAllReservation() {
        try{
            String query = "DELETE FROM reservation";
            iDatabase.executeUpdate(query);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public List<Reservation> getAllReservation() {
        String query = "SELECT *from reservation";
        List<Reservation> reservations = new ArrayList<Reservation>();
        try{
            ResultSet rs = iDatabase.executeQuery(query);
            while (rs.next()){
                 Reservation reservation=new Reservation();
                reservation.setCode(rs.getInt("idReservation"));
                reservation.setCheckInDate(rs.getDate(2));
                reservation.setCheckOut(rs.getDate(3));
                reservation.setBookedDate(rs.getDate(4));
                reservation.setGuest(String.valueOf(rs.getString(5)));
                reservation.setRoom(String.valueOf(rs.getString(6)));
                reservation.setRegistrationStatus(rs.getString(7));
                reservations.add(reservation);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return reservations;
    }

    @Override
    public Reservation getReservatinById(String idReservation) {
        String query = "SELECT *from reservation WHERE idReservation='"+idReservation+"'";
        Reservation reservation=new Reservation();
        try{
            ResultSet rs = iDatabase.executeQuery(query);
            while (rs.next()){
                reservation.setCode(rs.getInt(1));
                reservation.setCheckInDate(rs.getDate(2));
                reservation.setCheckOut(rs.getDate(3));
                reservation.setBookedDate(rs.getDate(4));
                reservation.setGuest(rs.getString(5));
                reservation.setRoom(rs.getString(6));
                reservation.setRegistrationStatus(rs.getString(7));
            }

        }catch (Exception e){

        }
        return reservation;
    }

}
