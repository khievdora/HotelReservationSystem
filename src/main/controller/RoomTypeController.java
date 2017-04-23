package main.controller;/**
 * Created by gebre on 4/22/2017.
 */

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.dbsub.DBFacade;
import main.dbsub.DBService;
import main.model.RoomType;

import java.net.URL;
import java.util.ResourceBundle;

public class RoomTypeController implements Initializable, IController {

    @FXML
    private TextField txtDescription;
    @FXML
    private TextField txtMaxGuest;

    private DBService dbService;

    private Stage roomTypeStage;
    private RoomTypeControllerListener listener;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.dbService = new DBFacade();
    }

    @Override
    public void setStage(Stage roomTypeStage) {
        this.roomTypeStage = roomTypeStage;
    }

    public void onButtonRoomTypeSaveClicked() throws NullPointerException {
        System.out.println("Button save clicked!!!");

        int code = 0;
        String desc = txtDescription.getText();
        int maxGuest = Integer.parseInt(txtMaxGuest.getText());

        RoomType roomType = new RoomType(code, desc, maxGuest);
        int result = this.dbService.saveRoomType(roomType);
        if (result != 0) {
            // Save success
            this.roomTypeStage.close();
            this.listener.onSaveSuccess(roomType);
        } else {
            // Save fail
            this.roomTypeStage.close();
            this.listener.onSaveFail("Save room type fail!!!");
        }
    }

    public void onButtonRoomTypeCancelClicked() {
        System.out.println("Button save clicked!!!");
        this.roomTypeStage.close();

    }

    public void setRoomTypeControllerListener(RoomTypeControllerListener listener) {
        this.listener = listener;
    }

    public interface RoomTypeControllerListener {
        public void onSaveSuccess(RoomType roomType);
        public void onSaveFail(String errMessage);
    }
}
