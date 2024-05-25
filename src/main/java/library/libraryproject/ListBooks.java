package library.libraryproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import library.libraryproject.libraryInventory.Book;
import library.libraryproject.libraryInventory.Inventory;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ListBooks implements Initializable {
    @FXML
    private Button ButtonBookAdd;
    @FXML
    private TableView<Book> tableListBooks;
    @FXML
    private Button ButtonListBookExit;
    @FXML
    private TextField textListBookId;
    @FXML
    private TextField textListBookName;
    @FXML
    private TextField textListBookAuthor;
    @FXML
    private TextField textListBookGenre;
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
    private Inventory inventory;

    public void goToMenu(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("menu.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.columnListBookName.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.columnListBookId.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.columnListBookAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        this.columnListBookGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));

        this.book = FXCollections.observableArrayList(Objects.requireNonNull(readFile()));
        try {
            this.tableListBooks.setItems(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addBook(ActionEvent actionEvent) {
        if (textListBookAuthor.getText().isEmpty() ||
                textListBookId.getText().isEmpty() ||
                textListBookGenre.getText().isEmpty() ||
                textListBookName.getText().isEmpty()) {

            SceneLoader.alertSpam();
        } else {
            book.add(new Book(textListBookName.getText(),
                    textListBookAuthor.getText(),
                    textListBookGenre.getText(),
                    textListBookId.getText()));
            saveFile(book);
        }
    }

    private static void saveFile(List<Book> book){
        try(PrintWriter pw = new PrintWriter("books.txt")){
            book.forEach(b -> pw.println(b.toString()));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Book> readFile(){
        try{
            return Files.lines(Paths.get("books.txt")).map(line -> new Book(line.split(";")[0],line.split(";")[1],
                    line.split(";")[2],line.split(";")[3])).collect(Collectors.toList());
        }catch (Exception e){
            return null;
        }
    }
}
