package main.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
public class RoomRegistrationController implements Initializable, IController {
    private RoomControllerListener listener;

    @FXML
    private Label lblRoomEditForm;
    @FXML
    private TextField txtCode;
    @FXML
    private TextField txtRoomName;
    @FXML
    private TextField txtRoomNumber;
    @FXML
    private TextField txtRoomStatus;
    @FXML
    private Spinner<Integer> txtRoomFloor;
    @FXML
    private TextField txtDescription;
    @FXML
    private ComboBox cmbRoomType;
    @FXML
    private Spinner txtMaxCapacity;
    @FXML
    private TextField txtStatus;
    @FXML
    private TextField txtPrice;

    @FXML
    private Button btnRoomCancel;
    @FXML
    private Button btnRoomSave;

    @FXML
    private ComboBox cbRoomRegistration;
    private List<Room> lstRooms = null;

    private Stage roomStage;
    private DBService dbService;
    private Room editedRoom;
    private boolean isEditWindow = false;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.dbService = new DBFacade();
        comboRoomTypelist();
    }

    @Override
    public void setStage(Stage stage) {
        this.roomStage = stage;

    }

    public void setEditedRoomType(Room room) {
        this.editedRoom = room;

        txtCode.setText(String.valueOf(this.editedRoom.getCode()));
        txtRoomName.setText(this.editedRoom.getRoomName());
        txtRoomNumber.setText(String.valueOf(this.editedRoom.getRoomNumber()));
        txtRoomStatus.setText(this.editedRoom.getRoomStatus());
        txtRoomFloor.getValueFactory().setValue(this.editedRoom.getFloor());
        txtDescription.setText(this.editedRoom.getDescription());
        txtMaxCapacity.getValueFactory().setValue(this.editedRoom.getMaxQuest());
        txtPrice.setText(String.valueOf(this.editedRoom.getPrice()));
        txtStatus.setText(this.editedRoom.getStatus());

    }

    public void setEditWindow(boolean value) {
        isEditWindow = value;
        lblRoomEditForm.setText("Room Edit Form");
    }

    public void onBtnRoomSaveClicked() {
        System.out.println("Button save clicked!!!");
        final Spinner<Integer> spinner = new Spinner<Integer>();
        final int initialValue = 3;
        SpinnerValueFactory<Integer> valueFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, initialValue);

        spinner.setValueFactory(valueFactory);

        int code = 0;
        String rName = txtRoomName.getText();
        int rNumber = Integer.parseInt(txtRoomNumber.getText());
        String rStatus = txtRoomStatus.getText();

        int rFloor = (int) txtRoomFloor.getValueFactory().getValue();
        String desc = txtDescription.getText();

//        String selected_txt = cmbRoomType.getItems(cmbRoomType.getSelectionModel());
        int maxCapacity = (int) txtMaxCapacity.getValueFactory().getValue();
        float rPrice = Float.parseFloat(txtPrice.getText());
        String status = txtStatus.getText();


        Room room = new Room(code, rName, rNumber, rStatus, rFloor, desc, null, maxCapacity, status, rPrice);
        int result = 0;
        if (!isEditWindow) {
            // Add new Room Type
            result = this.dbService.saveRoom(room);
            checkOperationResult(result, room);
        } else {
            // Update Room Type
            this.editedRoom.setCode(code);
            this.editedRoom.setRoomName(rName);
            this.editedRoom.setRoomNumber(rNumber);
            this.editedRoom.setFloor(rFloor);
            this.editedRoom.setRoomStatus(rStatus);
            this.editedRoom.setDescription(desc);
            this.editedRoom.setRoomType(null);
            this.editedRoom.setMaxQuest(maxCapacity);
            this.editedRoom.setStatus(status);
            this.editedRoom.setPrice(rPrice);
            result = this.dbService.updateRoom(editedRoom);
            checkOperationResult(result, room);
        }

        //if save success
//        Room room = null;
//        if(this.listener!=null){
//            this.listener.onSaveRoomSuccess(room);
//        }
//        //else fail message
//        this.listener.onSaveRoomFail("fail to save!!");
    }

    private void checkOperationResult(int result, Room room) {
        // Save success
        this.roomStage.close();
        if (!isEditWindow) {
            this.listener.onSaveRoomSuccess(room);
        } else {
            this.listener.onSaveRoomSuccess(room);
        }
    }

    public void setRoomControllerListener( RoomControllerListener listener){
        this.listener=listener;

    }
    public void onBtnRoomCancelClicked(){
        System.out.println("Button Cancel clicked!!");
        this.roomStage.close();
    }



    public interface RoomControllerListener{
        public void onSaveRoomSuccess(Room room);
        public void onUpdateRoomSuccess(Room room);
        public void onSaveRoomFail(String errMessage);

    }
    public void comboRoomTypelist() {

        List<Room> roomTypes = new RoomImpl().getAllRoom();
        lstRooms = new ArrayList<Room>();
        lstRooms = roomTypes;
        List<String> rooms = roomTypes.stream().map(rm -> rm.getDescription()).collect(Collectors.toList());
        ObservableList<String> roomTypesData = FXCollections.observableArrayList();

        for (String id : rooms) {
            roomTypesData.add(id);

        }
        cbRoomRegistration.setItems(null);
        cbRoomRegistration.setItems(roomTypesData);


    }

}
