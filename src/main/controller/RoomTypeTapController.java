package main.controller;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.stage.Stage;
import main.Shared.UrlLoader;
import main.Shared.WindowNavigation;
import main.dbsub.DBFacade;
import main.dbsub.DBService;
import main.model.RoomType;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * Created by gebre on 4/23/2017.
 */
public class RoomTypeTapController implements Initializable, RoomTypeController.RoomTypeControllerListener {

    @FXML
    private TableView tblRoomType;
    @FXML
    private TableColumn<RoomType, Void> num;
    @FXML
    private TableColumn<RoomType, String> idRoomType;
    @FXML
    private TableColumn<RoomType, String> description;
    @FXML
    private TableColumn<RoomType, Integer> maxCapacity;
    @FXML
    private TextField txtRoomTypeSearch;
    @FXML
    private Button btnRoomTypeSearch;
    @FXML
    private Button btnRoomTypeAdd;
    @FXML
    private Button btnRoomTypeRefresh;
    @FXML
    private Button btnRoomTypeEdit;
    @FXML
    private Button btnRoomTypeDelete;


    private DBService dbService;
    private ObservableList<RoomType> originalRoomTypeList = FXCollections.observableArrayList();
    private ObservableList<RoomType> modifiedRoomTypeList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dbService = new DBFacade();

        // Load RoomType list from Database
        originalRoomTypeList = FXCollections.observableArrayList(dbService.getAllRoomType());

        // Init Table view and load data
        loadRoomTypeListIntoView();

    }

    @Override
    public void onSaveSuccess(RoomType roomType) {
        originalRoomTypeList.add(roomType);
        onBtnRoomTypeRefreshClicked();
    }

    @Override
    public void onSaveFail(String errMessage) {
        // Alert message box to inform user.

    }

    public void loadRoomTypeListIntoView() {
        num = new TableColumn<>("No");
        idRoomType = new TableColumn<>("Id");
        description = new TableColumn<>("Description");
        maxCapacity = new TableColumn<>("Capacity");

        num.setCellFactory(col -> {
            TableCell<RoomType, Void> cell = new TableCell<>();
            cell.textProperty().bind(Bindings.createStringBinding(() -> {
                if (cell.isEmpty()) {
                    return null;
                } else {
                    return Integer.toString(cell.getIndex());
                }
            }, cell.emptyProperty(), cell.indexProperty()));
            return cell;
        });
        idRoomType.setCellValueFactory(new PropertyValueFactory<>("code"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        maxCapacity.setCellValueFactory(new PropertyValueFactory<>("maxCapacity"));

        //tblRoomType.getItems().setAll(originalRoomTypeList);
        tblRoomType.setItems(originalRoomTypeList);
        tblRoomType.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tblRoomType.getColumns().addAll(num, idRoomType, description, maxCapacity);
    }

    public void onTxtRoomTypeSearch(){

    }
    public void onBtnRoomTypeSearchClicked() {
        String textSearch = txtRoomTypeSearch.getText();
        if (!textSearch.isEmpty()) {
            searchRoomType(textSearch);
        }
    }
    public void onBtnRoomTypeAddClicked(){
        RoomTypeController roomTypeController = (RoomTypeController) new WindowNavigation().navigateToWindow("Add Room Type",
                "../../resource/view/RoomType.fxml");
        roomTypeController.setRoomTypeControllerListener(this);

    }
    public void onBtnRoomTypeRefreshClicked(){
        tblRoomType.setItems(originalRoomTypeList);
    }

    public void onBtnRoomTypeEditClicked(){

    }
    public void onBtnRoomTypeDeleteClicked(){

    }

    public void searchRoomType(String value) {
        modifiedRoomTypeList = originalRoomTypeList.stream()
                .filter(r -> r.getDescription().toLowerCase().contains(value.toLowerCase()))
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
        tblRoomType.setItems(modifiedRoomTypeList);
    }
}
