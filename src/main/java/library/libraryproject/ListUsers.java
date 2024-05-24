package library.libraryproject;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import library.libraryproject.libraryInventory.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListUsers implements Initializable {

    @FXML
    private TableView<User> tableListUsers;
    @FXML
    private Button buttonListUsersExit;
    @FXML
    private Button buttonListUsersSearch;
    @FXML
    private TextField textListUsersId;
    @FXML
    private TextField textListUsersName;
    @FXML
    private Button buttonListUserAddUser;
    @FXML
    private TableColumn<User, String>  columnListUsersId;
    @FXML
    private TableColumn<User, String> columnListUserName;
    @FXML
    private TableColumn<User, String> columnListUsersEmail;
    @FXML
    private TableColumn<User, Integer> columnListUserPhoneNumber;
    @FXML
    private TableColumn columnListUserRemove;
    private ObservableList<User> user;

    public void goToMenu(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("menu.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }

    public void goToCreateUser(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("CreateUser.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.columnListUserName.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.columnListUsersId.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.columnListUsersEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.columnListUserPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        this.user = FXCollections.observableArrayList(
                new User("Juan García García","1111","JuanGarcia@gmail.com",612345678),
                new User("Paco López Fernández","1112","PacoLopez@gmail.com",687654321),
                new User("Laura Ruíz García","1113","LauraRuz@gmail.com",600000008),
                new User("Eloise Zaonero Sotillo","1114","EloiseZaonero@gmail.com",612345678),
                new User("Sergi López Sánchez","1115","SergiLopez@gmail.com",666117846),
                new User("Miguel Ángel Gómez Mena","1116","MangelGomez@gmail.com",611222333)
        );
        try {
            this.tableListUsers.setItems(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
