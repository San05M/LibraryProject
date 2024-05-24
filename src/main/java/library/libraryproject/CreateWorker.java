package library.libraryproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateWorker {
    @FXML
    private Button bottomExitCreate;
    @FXML
    private TextField textCreateUser;
    @FXML
    private TextField textCreatePassword;
    @FXML
    private TextField textCreateId;
    @FXML
    private Button bottonCreateAcount;

    public void goToMenuCreate(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("menu.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }

    public void goToMenuExit(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("menu.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }
}
