package main.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.LoginWindow;
import main.authenticationsub.AuthenticationService;
import main.authenticationsub.AuthenticationSubcriber;
import main.authenticationsub.AuthenticatoinFacade;
import main.model.Account;

import java.io.InputStream;

/**
 * Created by Dora on 4/20/2017.
 */
public class LoginController implements AuthenticationSubcriber {

    @FXML
    private TextField txtUserName;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Label lblMessage;
    @FXML
    private ImageView imgHotel;

    private AuthenticationService authService;
    private LoginWindow loginWindow;

    public LoginController() {
        //System.out.println("LoginController is instantiated!!!");
        authService = new AuthenticatoinFacade();
        authService.registerAuthenticationSubscriber(this);
    }

    @Override
    public void onLoginSuccess(Account account) {
        // Navigate to Welcome screen
    }

    @Override
    public void onLoginFail(String errMessage) {
        // Display error message
        lblMessage.setText(errMessage);
        clearText();
    }

    @Override
    public void onSessionExpired() {
        // Don't need to implement because we are in Login screen. There's no session expired in this use case.
    }

    public void onButtonLoginClicked() {
        System.out.println("Button login clicked!!!");
        //authService.login(txtUserName.getText(), txtPassword.getText());
        this.loginWindow.navigateToMainWindow();
    }

    public void onButtonCancelClicked() {
        System.out.println("Button cancel clicked!!!");
        loginWindow.close();
    }

    public void setLoginWindow(LoginWindow loginWindow) {
        this.loginWindow = loginWindow;
    }

    public void clearText() {
        txtUserName.setText("");
        txtPassword.setText("");
    }

    public void setHotelImage(InputStream imageUrl) {
        //System.out.println("Image url : " + imageUrl);
        imgHotel.setImage(new Image(imageUrl));
        imgHotel.setSmooth(true);
    }

}
