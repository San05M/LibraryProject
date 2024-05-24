package library.libraryproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateLoan {
    @FXML
    private Button buttonExitCreateLoan;
    @FXML
    private Button buttonCreateCreateLoan;
    @FXML
    private TextField textUserIdCreateLoan;
    @FXML
    private TextField textBookCreateLoan;
    @FXML
    private TextField textLoanCreateLoan;
    @FXML
    private TextField textCheckCreateLoan;

    public void goToListLoan(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("ListLoan.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }

    public void goToMenu(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("menu.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }
}
