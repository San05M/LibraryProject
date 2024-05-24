package library.libraryproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Menu {
    @FXML
    private Button bottomViewUsers;
    @FXML
    private Button bottomViewInventory;
    @FXML
    private Button bottomViewLoans;
    @FXML
    private Button bottomCreateUser;
    @FXML
    private Button bottomExit;

    public void goToCreateUser(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("CreateWorker.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }

    public void goToListLoans(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("ListLoans.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }

    public void goToListBooks(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("ListBooks.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }

    public void goToListUsers(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("ListUsers.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }
}
