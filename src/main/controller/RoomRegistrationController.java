package main.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import main.dbsub.RoomTypeImpl;
import main.model.Room;
import main.model.RoomType;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * Created by gebre on 4/23/2017.
 */
public class RoomRegistrationController implements Initializable {
    private RoomControllerListener listener;

    @FXML
    private ComboBox cbRoomRegistration;
    private List<RoomType> lstRoomTypes = null;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboRoomTypelist();
    }
    public void onBtnRoomSaveClicked(){
        //if save success
        Room room = null;
        if(this.listener!=null){
            this.listener.onSaveRoomSuccess(room);
        }
        //else fail message
        this.listener.onSaveRoomFail("fail to save!!");
    }
    public void setRoomControllerListener( RoomControllerListener listener){
        this.listener=listener;

    }
    public interface RoomControllerListener{
        public void onSaveRoomSuccess(Room room);
        public void onSaveRoomFail(String errMessage);

    }
    public void comboRoomTypelist() {

        List<RoomType> roomTypes = new RoomTypeImpl().getAllRoomType();
        lstRoomTypes = new ArrayList<>();
        lstRoomTypes = roomTypes;
        List<String> rooms = roomTypes.stream().map(rm -> rm.getDescription()).collect(Collectors.toList());
        ObservableList<String> roomTypesData = FXCollections.observableArrayList();

        for (String id : rooms) {
            roomTypesData.add(id);

        }
        cbRoomRegistration.setItems(null);
        cbRoomRegistration.setItems(roomTypesData);


    }

}
