package library.libraryproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {
    @FXML
    private TextField textUserNameId;
    @FXML
    private TextField textPassword;
    @FXML
    private Button bottomAccessLogin;

    void goToMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(
                HelloApplication.class.getResource("Menu.fxml"));
        Scene view1Scene = new Scene(root);
        Stage stage =
                (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(view1Scene);
        stage.show();
    }
}
