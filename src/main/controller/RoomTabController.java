package main.controller;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.dbsub.DBFacade;
import main.dbsub.DBService;
import main.dbsub.RoomImpl;
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
public class RoomTabController implements Initializable, RoomRegistrationController.RoomControllerListener {
    @FXML
    private TableColumn<Room, IntegerProperty> code;
    @FXML
    private TableColumn<Room, StringProperty> roomName;
    @FXML
    private TableColumn<Room, IntegerProperty> roomNumber;
    @FXML
    private TableColumn<Room, StringProperty> roomStatus;
    @FXML
    private TableColumn<Room, IntegerProperty> floor;
    @FXML
    private TableColumn<Room, StringProperty> description;
    @FXML
    private TableColumn<Room, RoomType> roomType;
    @FXML
    private TableColumn<Room, IntegerProperty> maxQuest;
    @FXML
    private TableColumn<Room, StringProperty> status;
    @FXML
    private TableColumn<Room, FloatProperty> price;
    @FXML
    private TableView tblVWRoom;


    private DBService dbService;

    private List<Room> lstRooms;

    public RoomTabController(){
        this.dbService = new DBFacade();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        code = new TableColumn<>("Id");
        roomName = new TableColumn<>("Room Name");
        roomNumber = new TableColumn<>("Rooom No");
        roomStatus = new TableColumn<>("Room Status");
        floor = new TableColumn<>("Floor");
        description = new TableColumn<>("Description");
        roomType = new TableColumn<>("Room Type");
        maxQuest = new TableColumn<>("Mam Capacity");
        status = new TableColumn<>("Status");
        price = new TableColumn<>("Price");


        code.setCellValueFactory(new PropertyValueFactory<>("code"));
        roomName.setCellValueFactory(new PropertyValueFactory<>("roomName"));
        roomNumber.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        roomStatus.setCellValueFactory(new PropertyValueFactory<>("roomStatus"));
        floor.setCellValueFactory(new PropertyValueFactory<>("floor"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        roomType.setCellValueFactory(new PropertyValueFactory<>("roomType"));

        maxQuest.setCellValueFactory(new PropertyValueFactory<>("maxQuest"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        tblVWRoom.getItems().setAll(parseRoomLists());
        tblVWRoom.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tblVWRoom.getColumns().addAll(code, roomName, roomNumber, roomStatus, floor, description, roomType,maxQuest,status,price);

    }

    private List<Room> parseRoomLists() {
        lstRooms = this.dbService.getAllRoom();
        List<Room> rooms = new ArrayList<>();
        for(Room rm:lstRooms){
            int rmcode = rm.getCode();
            String rmName = rm.getRoomName();
            int rmNumber = rm.getRoomNumber();
            String rmStatus =rm.getStatus();
            int rmFloor = rm.getFloor();
            String rmDescription = rm.getDescription();
            RoomType rmRoomType = rm.getRoomType();
            int rmMaxCapacity = rm.getMaxQuest();
            String Status = rm.getStatus();
            Float rmPrice = rm.getPrice();
            Room room = new Room(rmcode,rmName,rmNumber,rmStatus,rmFloor,rmDescription,rmRoomType,rmMaxCapacity,Status,rmPrice);
            rooms.add(room);


        }
        final ObservableList<Room> list = FXCollections.observableArrayList();
        list.addAll(rooms);
        return list;
    }




    public void onTxtRoomSearch(){

    }
    public void onBtnRoomSearchClicked(){

    }
    public void onBtnRoomAddClicked(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../resource/view/RoomRegistrationForm.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            RoomRegistrationController roomRegistrationController = fxmlLoader.getController();
            roomRegistrationController.setRoomControllerListener(this);

            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void onBtnRoomRefreshClicked(){
        System.out.println("room button refresh");

    }
    public void onBtnRoomEditClicked(){

    }
    public void onBtnRoomDeleteClicked(){

    }


    @Override
    public void onSaveRoomSuccess(Room room) {
        System.out.println("Save button clicked!!");
    }

    @Override
    public void onSaveRoomFail(String errMessage) {

    }
}
