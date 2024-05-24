package library.libraryproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ListBooks {
    @FXML
    private Button ButtonListBookExit;
    @FXML
    private Button ButtonListBookSearch;
    @FXML
    private TextField textListBookId;
    @FXML
    private TextField textListBookName;
    @FXML
    private TextField textListBookAuthor;
    @FXML
    private TextField textListBookGenre;
    @FXML
    private Button buttonListBookAddBook;
    @FXML
    private TableColumn columnListBookId;
    @FXML
    private TableColumn columnListBookName;
    @FXML
    private TableColumn columnListBookAuthor;
    @FXML
    private TableColumn columnListBookGenre;
    @FXML
    private TableColumn columnListBookRemove;

    public void goToMenu(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("menu.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }

    public void goToCreateBook(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("CreateBook.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }
}
