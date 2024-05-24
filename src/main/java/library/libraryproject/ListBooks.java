package library.libraryproject;

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
import library.libraryproject.libraryInventory.Book;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListBooks implements Initializable {
    @FXML
    private TableView<Book> tableListBooks;
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
    private TableColumn<Book, String> columnListBookId;
    @FXML
    private TableColumn<Book, String> columnListBookName;
    @FXML
    private TableColumn<Book, String> columnListBookAuthor;
    @FXML
    private TableColumn<Book, String> columnListBookGenre;
    @FXML
    private TableColumn columnListBookRemove;
    private ObservableList<Book> book;

    public void goToMenu(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("menu.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }

    public void goToCreateBook(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("CreateBook.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.columnListBookName.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.columnListBookId.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.columnListBookAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        this.columnListBookGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));

        this.book = FXCollections.observableArrayList(
                new Book("The Priory of the Orange Tree", "Samantha Shannon", "Fantasy Fiction", "12345678")
        );
        try {
            this.tableListBooks.setItems(book);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
