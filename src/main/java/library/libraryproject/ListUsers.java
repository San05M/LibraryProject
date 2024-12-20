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
import library.libraryproject.libraryInventory.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
/**
 * Controller for the list of users screen.
 * @author sandramoyaortega
 * @version 2
 * @since 1
 */
public class ListUsers implements Initializable {

    @FXML
    private TextField textListPhoneNumber;
    @FXML
    private Button buttonListUsersAdd;
    @FXML
    private TextField textListUsersEmail;
    @FXML
    private Button buttonListUsersExit;
    @FXML
    private TextField textListUsersId;
    @FXML
    private TextField textListUsersName;
    @FXML
    private TableView<User> tableListUsers;
    @FXML
    private TableColumn<User, String>  columnListUsersId;
    @FXML
    private TableColumn<User, String> columnListUserName;
    @FXML
    private TableColumn<User, String> columnListUsersEmail;
    @FXML
    private TableColumn<User, Integer> columnListUserPhoneNumber;
    @FXML
    private TableColumn columnListUserRemove;
    private ObservableList<User> user;

    /**
     * Navigates back to the main menu.
     */
    public void goToMenu(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("menu.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }

    /**
     * Initializes the user interface.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.columnListUserName.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.columnListUsersId.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.columnListUsersEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.columnListUserPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        this.user = FXCollections.observableArrayList(Objects.requireNonNull(readFile()));
        try {
            this.tableListUsers.setItems(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a new user to the list.
     */
    public void addUser(ActionEvent actionEvent) throws IOException {
        if (textListUsersName.getText().isEmpty() ||
                textListUsersId.getText().isEmpty() ||
                textListUsersEmail.getText().isEmpty() ||
                textListPhoneNumber.getText().isEmpty()) {

            SceneLoader.alertSpam("Error. Field empty.");
        } else {
            user.add(new User(textListUsersName.getText(),
                    textListUsersId.getText(),
                    textListUsersEmail.getText(),
                    textListPhoneNumber.getText()));
            saveFile(user);

        }
    }

    /**
     * Save the file of the users.
     */
    private static void saveFile(List<User> user){
        try(PrintWriter pw = new PrintWriter("user.txt")){
            user.forEach(u -> pw.println(u.toString()));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Read the users file.
     */
    private static List<User> readFile(){
        try{
            return Files.lines(Paths.get("user.txt"))
                    .map(line -> new User(line.split(";")[0],
                            line.split(";")[1],
                            line.split(";")[2],
                            line.split(";")[3]))
                    .collect(Collectors.toList());
        }catch (Exception e){
            return null;
        }
    }
}
