package home;

import home.dbconnection.DataAccessFacade;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by gebre on 4/19/2017.
 */
public class MainWindow {
    @FXML
    private TableColumn codeCol;

    @FXML
    private TableColumn userNameCol;

    @FXML
    private TableColumn passwordCol;
    @FXML
    private TableColumn statusCol;

    @FXML
    private TableColumn roleCol;
    @FXML
    private javafx.scene.control.TableView accountTableView;
    ;

    public void load(ActionEvent event) throws Exception {
        DataAccessFacade facade = new DataAccessFacade();
        final ObservableList<Account> obserList;
        facade.openConnection();
        String querySql = "select * from account";
        ResultSet result = facade.executeQuery(querySql);
        List<Account> accList = new ArrayList<>();

        Account acc = null;
        while (result.next()) {
            String co=(result.getString("idAccount"));
            String un=(result.getString("username"));
            String pw=(result.getString("password"));
            String st=(result.getString("status"));
            String ro=(result.getString("userRole"));
            acc= new Account(co,un,pw,st,ro);
            accList.add(acc);
        }
        final ObservableList<Account> list = FXCollections.observableArrayList();
        list.addAll(accList);

        codeCol.setCellValueFactory(
                new PropertyValueFactory<Account, String>("code")
        );
        userNameCol.setCellValueFactory(
                new PropertyValueFactory<Account, String>("username")
        );
        passwordCol.setCellValueFactory(
                new PropertyValueFactory<Account, String>("password")
        );
        statusCol.setCellValueFactory(
                new PropertyValueFactory<Account, String>("status")
        );
        roleCol.setCellValueFactory(
                new PropertyValueFactory<Account, String>("role")
        );
        accountTableView.setItems(list);
    }
}

class Account {
    private SimpleStringProperty code = null;
    private SimpleStringProperty username = null;
    private SimpleStringProperty password = null;
    private SimpleStringProperty status = null;
    private SimpleStringProperty role = null;

    public Account(String fName, String lName, String email, String role, String stat) {
        this.code = new SimpleStringProperty(fName);
        this.username = new SimpleStringProperty(lName);
        this.password = new SimpleStringProperty(email);
        this.status = new SimpleStringProperty(role);
        this.status = new SimpleStringProperty(stat);
    }

    public String getUserName() {
        return username.get();
    }

    public void setUserName(String fName) {
        username.set(fName);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String fName) {
        password.set(fName);
    }

    public String getRole() {
        return role.get();
    }

    public void setRole(String fName) {
        role.set(fName);
    }

    public String getStatus() {
        return status.get();
    }

    public void setStatus(String fName) {
        status.set(fName);
    }

}