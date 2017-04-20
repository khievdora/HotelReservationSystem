package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.Shared.UrlLoader;
import main.controller.LoginController;

/**
 * Created by gebre on 4/18/2017.
 */
public class LoginWindow extends Application {

    private Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.window = primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(UrlLoader.loadView("Login.fxml")));
        Parent root = loader.load();
        Scene scene = new Scene(root, 400,400);
        this.window.setScene(scene);

        // Init LoginController
        LoginController loginController = loader.getController();
        loginController.setLoginWindow(this);
        loginController.setHotelImage(getClass().getResourceAsStream(UrlLoader.loadAsset("icHotel.png")));

        this.window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void navigateToWelcomeView() {

    }

    public void close() {
        this.window.close();
    }
}
