package java.authentication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by gebre on 4/18/2017.
 */
public class Login {
    @FXML
    private Label lblStatus;

    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtPassword;

    public void login(ActionEvent event) throws Exception{
        if(txtUserName.getText().equals("user") && txtPassword.getText().equals("pass")){
            lblStatus.setText("Login successfull");
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../../src/view/MainWindow.fxml"));
            Scene scene = new Scene(root, 600,400);
            primaryStage.setScene(scene);
            primaryStage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();

        }
        else {
            lblStatus.setText("Login failed");
        }
    }
}
