package main.controller;

/**
 * Created by Gize on 4/20/2017.
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import main.ReservationSub.ReservationServiceProvider.ResServiceImplementation;
import main.ReservationSub.payment.CreditPayment;
import main.ReservationSub.payment.PaymentBusiness;
import main.dbconnection.DataAccessFacade;
import main.model.Reservation;
import main.model.Room;
import main.model.Guest;


import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ReservationCtrl implements Initializable {
    @FXML
    private javafx.scene.control.TableView homeTableView;

    @FXML
    private TableColumn<Reservation, String> code;
    @FXML
    private TableColumn<Reservation, String> firstName;
    @FXML
    private TableColumn<Reservation, String> lastName;
    @FXML
    private TableColumn<Reservation, Date> checkInDate;
    @FXML
    private TableColumn<Reservation, Date> bookedDate;
    @FXML
    private TableColumn<Reservation, Date> checkOutDate;
    @FXML
    private TableColumn<Reservation, String> status;
    @FXML
    private ComboBox comboGuest;
    @FXML
    private ComboBox comboRoom;
    @FXML
    private ComboBox comboStatus;
    @FXML
    private DatePicker dpCheckIn;
    @FXML
    private DatePicker dpCheckOut;
    @FXML
    private DatePicker dpBooked;
    @FXML
    private TextField txtCode;

    public void initialize(ActionEvent actionEvent) {


    }

    private List<Reservation> parseUserList() {
        DataAccessFacade facade = new DataAccessFacade();
        final ObservableList<Reservation> obserList;
        facade.openConnection();
        String querySql = "select * from reservation where idReservation=?";
        String querySqlRoom = "select * from room where idRoom=?";
        String querySqlGuest = "select * from guest where idGuest=?";

        ResultSet result = facade.executeQuery(querySql, "1");
        List<Reservation> accList = new ArrayList<>();

        Reservation acc = new Reservation();
        try {
            while (result.next()) {

                try {
                    acc.setCode(result.getString("idReservation"));
                    acc.setRoom(getRoom(querySqlRoom, result.getString("room1")));
                    acc.setGuest(getGuest(querySqlGuest, result.getString("guest")));
                    acc.setCheckInDate(result.getDate("checkInDate"));
                    acc.setBookedDate(result.getDate("bookedDate"));
                    acc.setCheckOut(result.getDate("checkOutDate"));
                    acc.setRegistrationStatus(result.getString("regervationStatus"));
                    accList.add(acc);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        final ObservableList<Reservation> list = FXCollections.observableArrayList();
        list.addAll(accList);
        return list;
    }

    private String getRoom(String sql, String value) {
        DataAccessFacade facade = new DataAccessFacade();
        final ObservableList<Reservation> obserList;
        facade.openConnection();
        List<String> rooms = new ArrayList<>();
        ResultSet result = facade.executeQuery(sql, value);
        try {
            while (result.next()) {
                rooms.add(result.getString("roomNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (rooms.size() > 0) {
            return rooms.get(0);
        }
        return null;
    }

    private String getGuest(String sql, String value) {
        DataAccessFacade facade = new DataAccessFacade();
        facade.openConnection();

        final ObservableList<Reservation> obserList;
        List<String> rooms = new ArrayList<>();
        ResultSet result = facade.executeQuery(sql, value);
        try {
            while (result.next()) {
                rooms.add(result.getString("firstName"));
                rooms.add(result.getString("lastName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (rooms.size() > 0) {
            return rooms.get(0) + " " + rooms.get(1);
        }
        return null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        code = new TableColumn("Id");
        firstName = new TableColumn("Room");
        lastName = new TableColumn("Guest");
        checkInDate = new TableColumn("CheckIn Date");
        bookedDate = new TableColumn("Booked Date");
        checkOutDate = new TableColumn("Check Out Date");
        status = new TableColumn("Status");

        code.setCellValueFactory(new PropertyValueFactory<>("code"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("room"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("guest"));
        checkInDate.setCellValueFactory(new PropertyValueFactory<>("checkInDate"));
        bookedDate.setCellValueFactory(new PropertyValueFactory<>("bookedDate"));
        checkOutDate.setCellValueFactory(new PropertyValueFactory<>("checkOut"));
        status.setCellValueFactory(new PropertyValueFactory<>("registrationStatus"));

        homeTableView.getItems().setAll(parseUserList());
        homeTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        // homeTableView.getColumns().remove(0);
        // homeTableView.getColumns().remove(0);

        homeTableView.getColumns().addAll(code, firstName, lastName, checkInDate, bookedDate, checkOutDate, status);
        comboRoomlist();
        comboGuestlist();
        comboStatusList();
        dpBooked.setValue(LocalDate.now());
        dpCheckIn.setValue(LocalDate.now());
        dpCheckOut.setValue(LocalDate.now());
    }

    List<Room> allRooms = null;
    List<Guest> allGuests = null;

    public void comboRoomlist() {
        allRooms = new ArrayList<>();
        DataAccessFacade facade = new DataAccessFacade();
        String querySqlRoom = "select * from room where idRoom=?";
        facade.openConnection();
        List<Integer> rooms = new ArrayList<>();
        ResultSet result = facade.executeQuery(querySqlRoom, "1");
        try {

            while (result.next()) {
                Room room = new Room();
                room.setCode(result.getString("idRoom"));
                room.setRoomName(result.getString("roomName"));
                room.setRoomNumber(result.getInt("roomNumber"));
                room.setRoomStatus(result.getString("roomStatus"));
                room.setFloor(result.getInt("floor"));
                room.setRoomType(result.getString("roomType"));
                room.setMaxQuest(result.getInt("maxQuest"));
                int roomNo = result.getInt("roomNumber");

                rooms.add(roomNo);
                allRooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // List<String> roomNums = rooms.stream().map(rm -> rm.getRoomNumber()).collect(Collectors.toList());

        ObservableList<Integer> data2 = FXCollections.observableArrayList();

        for (int id : rooms) {
            data2.add(id);

        }
        comboRoom.setItems(null);
        comboRoom.setItems(data2);


    }

    public void comboGuestlist() {

        DataAccessFacade facade = new DataAccessFacade();
        String querySqlRoom = "select * from guest where idGuest=?";
        facade.openConnection();
        List<String> guests = new ArrayList<>();
        ResultSet result = facade.executeQuery(querySqlRoom, "1");
        try {
            allGuests = new ArrayList<>();
            while (result.next()) {
                Guest gu = new Guest();
                gu.setCode(result.getString("idGuest"));
                String fn = result.getString("firstName");
                String ln = result.getString("lastName");
                gu.setfName(fn);
                gu.setlName(ln);
                guests.add(fn + " " + ln);
                allGuests.add(gu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // List<String> roomNums = rooms.stream().map(rm -> rm.getRoomNumber()).collect(Collectors.toList());

        ObservableList<String> data2 = FXCollections.observableArrayList();

        for (String id : guests) {
            data2.add(id);

        }
        comboGuest.setItems(null);
        comboGuest.setItems(data2);

    }

    public void comboStatusList() {
        ObservableList<String> options = FXCollections.observableArrayList(

                "Check In", "Confirmed", "Waiting");

        comboStatus.setItems(options);
        comboStatus.getSelectionModel().selectFirst();
    }

    public void saveNew() {
        Reservation resObj = new Reservation();
        resObj.setCode(txtCode.getText().trim());

        String guestCode = "001";//String.valueOf(allGuests.stream().filter(g->(g.getfName()+" "+g.getlName()).equals(comboGuest.getValue().toString())).findFirst());
        String roomCode = "001";
        String.valueOf(allRooms.stream().filter(r -> new Integer(r.getRoomNumber()).equals(comboRoom.getValue().toString().trim())).findFirst());

        resObj.setGuest(guestCode);
        resObj.setRoom(roomCode);
        resObj.setCheckInDate(Date.valueOf(dpCheckIn.getValue()));
        resObj.setBookedDate(Date.valueOf(dpBooked.getValue()));
        resObj.setCheckOut(Date.valueOf(dpCheckOut.getValue()));
        resObj.setRegistrationStatus(comboStatus.getValue().toString());
        save(resObj);

    }

    public void save(Reservation res) {
        try {
            ResServiceImplementation impl = new ResServiceImplementation();
            boolean isSaved = impl.addReservation(res);
            if (isSaved) {
                JOptionPane.showMessageDialog(null, "Reserved Successfully.!");
            } else {
                JOptionPane.showMessageDialog(null, "There was an error in saving!");
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "There was an error in saving!");
            // e.printStackTrace();
        }
    }

    public void makeValidation() {

    }

    public void provideQuarantee() {
        System.out.println("Please provide a quarantine before reserving.");
        return;
    }

    public void checkOut() {
        Reservation person = (Reservation) homeTableView.getSelectionModel().getSelectedItem();
        if (person != null) {
            if (person.getRegistrationStatus() == "CheckIn") {
                PaymentBusiness payBu = new PaymentBusiness();
                payBu.setPayment(new CreditPayment());
                payBu.pay();
                person.setRegistrationStatus("CheckedOut");
                //update reservation here

                JOptionPane.showMessageDialog(null, "Successfully check out!");
            } else {
                JOptionPane.showMessageDialog(null, "You can not check out un checked In reservation!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please first select the row to check out!");
        }

    }

    public void cancelReservation() {
        Reservation person = (Reservation) homeTableView.getSelectionModel().getSelectedItem();
        if (person != null) {
            if (person.getRegistrationStatus() != "Cancelled") {
                person.setRegistrationStatus("Cancelled");
                //update the registration here

            } else {
                JOptionPane.showMessageDialog(null, "This reservation is already cancelled!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please first select the row to cancel!");
        }
    }

    public void deleteReservation() {
        Reservation person = (Reservation) homeTableView.getSelectionModel().getSelectedItem();
        if (person != null) {
            //delete the selected reservation here.
            if (true) {

                JOptionPane.showMessageDialog(null, "Successfully Deleted!");

            } else {
                JOptionPane.showMessageDialog(null, "There is an error in deleting the reservation!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please first select the row to delete!");
        }
    }
}

