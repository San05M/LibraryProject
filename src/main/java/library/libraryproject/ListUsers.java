package library.libraryproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ListUsers {
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
    private TableColumn columnListUsersId;
    @FXML
    private TableColumn columnListUserName;
    @FXML
    private TableColumn columnListUsersEmail;
    @FXML
    private TableColumn columnListUserPhoneNumber;
    @FXML
    private TableColumn columnListUserRemove;

    public void goToMenu(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("menu.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }

    public void goToCreateUser(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("CreateUser.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }
}
