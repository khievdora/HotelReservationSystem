package main.ReservationSub.ReservationServiceProvider;

import main.dbconnection.DataAccessFacade;
import main.model.Reservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gize on 4/20/2017.
 */
public class ResServiceImplementation implements ResServiceProvider {
    DataAccessFacade facade = new DataAccessFacade();
    private Connection connection = null;
    private PreparedStatement prep = null;

    public void openConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HotelReservation?useSSL=false", "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        if (prep != null) {
            try {
                prep.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean addReservation(Reservation res) {
        Statement st;
        boolean isTrue=false;
        PreparedStatement preparedStmt = null;
        openConnection();
        try {
            preparedStmt = connection
                    .prepareStatement("insert into reservation (idReservation, checkInDate, CheckOutDate, bookedDate, guest,room1,regervationStatus) values(?,?,?,?,?,?,?)");
            preparedStmt.setString(1, res.getCode());
            preparedStmt.setDate(2, res.getCheckInDate());
            preparedStmt.setDate(3, res.getCheckOut());
            preparedStmt.setDate(4, res.getBookedDate());
            preparedStmt.setString(5, res.getGuest());
            preparedStmt.setString(6, res.getRoom());
            preparedStmt.setString(7, res.getRegistrationStatus());
            preparedStmt.execute();
            isTrue=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();
        return isTrue;
    }

    @Override
    public boolean editReservation(Reservation res) {
        return false;
    }

    @Override
    public List<Reservation> getAllReservation() {
        return null;
    }

    @Override
    public Reservation getReservatinById(String id) {
        DataAccessFacade facade = new DataAccessFacade();
        String querySqlRoom = "select * from reservation where idReservation=?";
        facade.openConnection();
        List<Reservation> guests = new ArrayList<>();
        ResultSet result = facade.executeQuery(querySqlRoom, id);
        try {

            while (result.next()) {
                String code = (result.getString("idReservation"));
                String room = (result.getString("room1"));
                String guest = (result.getString("guest"));
                Date checkIn = (result.getDate("checkInDate"));
                Date booked = (result.getDate("bookedDate"));
                Date checkOut = (result.getDate("checkOutDate"));
                String status = (result.getString("regervationStatus"));
                Reservation obj = new Reservation(code, checkIn, booked, checkOut, guest, room, status);
                guests.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (guests.size() > 0) {
            return guests.get(0);
        }
        closeConnection();
        return null;
    }

    @Override
    public boolean deleteAllReservation() {
        return false;
    }

    @Override
    public boolean deleteReservationById(String id) {
        return false;
    }
}
