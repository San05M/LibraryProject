package library.libraryproject;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import library.libraryproject.libraryInventory.Book;
import library.libraryproject.libraryInventory.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateUser implements Initializable {
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
    private ObservableList<User> u;
    public void goToMenu(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("menu.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }

    public void goToListUsers(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("ListUsers.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
