package library.libraryproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateBook {
    @FXML
    private Button buttonExitCreateBook;
    @FXML
    private TextField textNameCreateBook;
    @FXML
    private TextField textAuthorCreateBook;
    @FXML
    private TextField textGenreCreateBook;
    @FXML
    private Button buttonCreateCreateBook;

    public void goToListBook(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("ListBook.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }

    public void goToMenu(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("menu.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }
}
