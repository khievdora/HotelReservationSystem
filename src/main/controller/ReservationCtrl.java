package main.controller;

/**
 * Created by Gize on 4/20/2017.
 */

import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.ReservationSub.ReservationServiceProvider.ResServiceImplementation;
import main.ReservationSub.payment.CreditPayment;
import main.ReservationSub.payment.PaymentBusiness;
import main.Shared.UrlLoader;
import main.dbconnection.DataAccessFacade;
import main.dbsub.GuestImpl;
import main.dbsub.ReservationImpl;
import main.model.Reservation;
import main.model.Room;
import main.model.Guest;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;


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
    private ComboBox comboSearch;
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

    List<Reservation> regList = null;

    private List<Reservation> parseReservationList() {


        String querySqlRoom = "select * from room where idRoom=?";


        regList = new ReservationImpl().getAllReservation();
        List<Reservation> modifiedList = new ReservationImpl().getAllReservation();

        for (Reservation reg : regList) {

            IntegerProperty code = reg.getCode();
            String room = getRoom(querySqlRoom, reg.getRoom());
            String guest = (getGuest(reg.getGuest()));
            Date checkIn = reg.getCheckInDate();
            Date booked = reg.getBookedDate();
            Date checkOut = reg.getCheckOut();
            String status = reg.getRegistrationStatus();
            Reservation acc = new Reservation(code.get(), checkIn, booked, checkOut, guest, room, status);
            modifiedList.add(acc);

        }
        final ObservableList<Reservation> list = FXCollections.observableArrayList();
        list.addAll(modifiedList);
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

    private String getGuest(String value) {
        main.model.Guest guest = new GuestImpl().getGuestById(value);
        if (guest != null) {
            return guest.getlName();
        } else {
            return null;
        }
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

        homeTableView.getItems().setAll(parseReservationList());
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

    public void refreshHomeTableView() {
        homeTableView.refresh();
        homeTableView.setItems(null);
        regList = null;
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
//                Room room = new Room();
//                room.setCode(result.getString("idRoom"));
//                room.setRoomName(result.getString("roomName"));
//                room.setRoomNumber(result.getInt("roomNumber"));
//                room.setRoomStatus(result.getString("roomStatus"));
//                room.setFloor(result.getInt("floor"));
//                room.setRoomType(result.getString("roomType"));
//                room.setMaxCapacity(result.getInt("maxQuest"));
                int roomNo = result.getInt("roomNumber");

                rooms.add(roomNo);
                //allRooms.add(room);
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


        List<Guest> guests = new GuestImpl().getAllGuest();

//        try {
//            allGuests = new ArrayList<>();
//            while (result.next()) {
//                // Guest gu = new Guest();
//                // gu.setCode(result.getString("idGuest"));
//                String fn = result.getString("firstName");
//                String ln = result.getString("lastName");
//                //  gu.setfName(fn);
//                // gu.setlName(ln);
//                guests.add(fn + " " + ln);
//                // allGuests.add(gu);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        // List<String> roomNums = rooms.stream().map(rm -> rm.getRoomNumber()).collect(Collectors.toList());

        ObservableList<Guest> data2 = FXCollections.observableArrayList();

        for (Guest id : guests) {
            data2.add(id);

        }
        comboGuest.setItems(null);
        comboGuest.setItems(data2);
        comboSearch.setItems(null);
        comboSearch.setItems(data2);
        comboSearch.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue ov, Object t, Object t1) {
                if (t1 != null) {
                    // ObservableList combox3 = FXCollections.observableArrayList((List) combox3Map.get(t1));

                }
            }
        });

    }

    public void comboStatusList() {
        ObservableList<String> options = FXCollections.observableArrayList(

                "Check In", "Confirmed", "Waiting");

        comboStatus.setItems(options);
        comboStatus.getSelectionModel().selectFirst();
    }

    public void saveNew() {

        String code = txtCode.getText().trim();
        String guestCode = "001";//String.valueOf(allGuests.stream().filter(g->(g.getfName()+" "+g.getlName()).equals(comboGuest.getValue().toString())).findFirst());
        String roomCode = "001";
        String.valueOf(allRooms.stream().filter(r -> new Integer(r.getRoomNumber()).equals(comboRoom.getValue().toString().trim())).findFirst());

        // resObj.setGuest(guestCode);
        // resObj.setRoom(roomCode);
        Date checkIN = Date.valueOf(dpCheckIn.getValue());
        Date booked = Date.valueOf(dpCheckIn.getValue());
        Date checkOut = Date.valueOf(dpCheckIn.getValue());
        String status = (comboStatus.getValue().toString());
        Reservation resObj = new Reservation(Integer.parseInt(code), checkIN, checkOut, booked, guestCode, roomCode, status);
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
            if (person.getRegistrationStatus().equals("checkin")) {
                Payment payment = new Payment();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(UrlLoader.loadView("Payment.fxml")));
                Stage stage = new Stage();
                try {
                    Parent root = loader.load();
                    stage.setTitle("Payment Form");
                    stage.setScene(new Scene(root));
                    stage.show();

                    // this.window.hide();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
                //  new ReservationImpl().updateReservation(person);
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
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Confirmation");
            alert.setHeaderText("Look,Confirmation Delete");
            alert.setContentText("Are you sure you want to delete?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                //delete the selected reservation here.

                boolean isDeleted = new ReservationImpl().deleteReservationById(person.getCode().toString());
                if (isDeleted) {

                    JOptionPane.showMessageDialog(null, "Successfully Deleted!");

                } else {
                    JOptionPane.showMessageDialog(null, "There is an error in deleting the reservation!");
                }
            } else {
                // ... user chose CANCEL or closed the dialog
            }


        } else {
            JOptionPane.showMessageDialog(null, "Please first select the row to delete!");
        }
    }

}

