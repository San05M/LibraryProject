package library.libraryproject;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import library.libraryproject.libraryInventory.Inventory;
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
    private Inventory inventory;

    public void goToMenu(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("menu.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }

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

    public void addUser(ActionEvent actionEvent) throws IOException {
        if (textListUsersName.getText().isEmpty() ||
                textListUsersId.getText().isEmpty() ||
                textListUsersEmail.getText().isEmpty() ||
                textListPhoneNumber.getText().isEmpty()) {

            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setTitle("Error");
            dialog.setHeaderText("Error adding data");
            dialog.setContentText("No field can be empty");
            dialog.showAndWait();
        } else {
            user.add(new User(textListUsersName.getText(),
                    textListUsersId.getText(),
                    textListUsersEmail.getText(),
                    textListPhoneNumber.getText()));
            saveFile(user);

        }
    }
    private static void saveFile(List<User> user){
        try(PrintWriter pw = new PrintWriter("user.txt")){
            user.forEach(u -> pw.println(u.toString()));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static  List<User> readFile(){
        try{
            return Files.lines(Paths.get("user.txt")).map(line -> new User(line.split(";")[0],line.split(";")[1],
                    line.split(";")[2],line.split(";")[3])).collect(Collectors.toList());
        }catch (Exception e){
            return null;
        }
    }
}
