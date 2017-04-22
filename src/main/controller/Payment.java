package main.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import main.ReservationSub.payment.CashPayment;
import main.ReservationSub.payment.PaymentBusiness;
import main.model.Reservation;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gize on 4/21/2017.
 */
public class Payment implements Initializable {
    @FXML
    private ComboBox comboPayment;
    @FXML
    private TextField txtGuest;
    @FXML
    private TextField txtRoom;
    @FXML
    private TextField txtCheckIn;
    @FXML
    private TextField txtCheckOut;

    public Reservation reservation;

    @Override

    public void initialize(URL location, ResourceBundle resources) {
        if (reservation != null) {
            txtGuest.setText(reservation.getGuest().getlName());
            txtRoom.setText(reservation.getRoom().getRoomName());
            txtCheckIn.setText(reservation.getCheckInDate().toString());
            txtCheckOut.setText(reservation.getCheckOut().toString());
            comboStatusList();
        }
    }

    public void comboStatusList() {
        ObservableList<String> options = FXCollections.observableArrayList(

                "Pay By Cash", "Pay By Credit", "Pay By Debit", "Pay By Paypal ");

        comboPayment.setItems(options);
        comboPayment.getSelectionModel().selectFirst();
    }

    public void pay() {
        PaymentBusiness payBu = new PaymentBusiness();
        payBu.setPayment(new CashPayment());
        payBu.pay();
        JOptionPane.showMessageDialog(null, "Payment Successfully.!");

    }
}
