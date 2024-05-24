package library.libraryproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateUser {
    @FXML
    private Button buttonExitCreateUser;
    @FXML
    private TextField textNameCreateUser;
    @FXML
    private TextField textIdCreateUser;
    @FXML
    private TextField textEmailCreateUser;
    @FXML
    private TextField textPhoneNumberCreateUser;
    @FXML
    private Button ButtonCreateCreateUsser;

    public void goToMenu(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("menu.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }

    public void goToListUsers(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("ListUsers.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }
}
