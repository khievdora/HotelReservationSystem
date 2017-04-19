package home.authentication;

import home.dbconnection.DataAccessFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public void login(ActionEvent event) throws Exception {
        DataAccessFacade facade = new DataAccessFacade();

        facade.openConnection();
        String querySql = "select * from account where username=?";
        String value = txtUserName.getText();
        ResultSet result = facade.executeQuery(querySql, value);
        List<String> passList = new ArrayList<String>();
        if (result != null) {
            while (result.next()) {
                passList.add(result.getString("password"));
            }

            if (passList.size() > 0) {
                String password  = passList.get(0);


                if (password.equals(txtPassword.getText())) {
                    lblStatus.setText("Login successful");
                    Stage primaryStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("../MainWindow.fxml"));
                    Scene scene = new Scene(root, 600, 400);
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    ((Node) (event.getSource())).getScene().getWindow().hide();

                } else {
                    lblStatus.setText("Wrong password");
                }
            } else {
                lblStatus.setText("Invalid User Name");
            }
        }

    }
}
