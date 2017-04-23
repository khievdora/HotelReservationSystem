package main.controller;

import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 * Created by gebre on 4/22/2017.
 */
public abstract class IController {
    @FXML
    private RoomRegistrationController roomAdd;
    @FXML
    private RoomRegistrationController roomRefresh;
    @FXML
    private RoomRegistrationController roomEdit;
    @FXML
    private RoomRegistrationController roomDelete;
    @FXML
    private RoomRegistrationController roomTypeAdd;
    @FXML
    private RoomRegistrationController roomTypeRefresh;
    @FXML
    private RoomRegistrationController roomTypeEdit;
    @FXML
    private RoomRegistrationController roomTypeDelete;

    public abstract void onAddNewForm(Stage stage);
    public abstract void onRefreshForm(Stage stage);
    public abstract void onEditForm(Stage stage);
    public abstract void onDeleteForm(Stage stage);
}
