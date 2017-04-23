package main.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.awt.*;

/**
 * Created by gebre on 4/23/2017.
 */
public class RoomTabController {
    @FXML
    private TextField txtRoomSearch;
    @FXML
    private Button btnRoomSearch;

    @FXML
    private TableView tblVWRoom;




    public void onTxtRoomSearch(){

    }
    public void onBtnRoomSearchClicked(){

    }
    public void onBtnRoomAddClicked(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../resource/view/AddRoom.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
    public void onBtnRoomRefreshClicked(){

    }
    public void onBtnRoomEditClicked(){

    }
    public void onBtnRoomDeleteClicked(){

    }

}
