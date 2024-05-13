package library.libraryproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class ListUsers {
    @FXML
    private Button buttonListUsersExit;
    @FXML
    private Button buttonListUsersSearch;
    @FXML
    private TextField textListUsersId;
    @FXML
    private TextField textListUsersName;
    @FXML
    private Button buttonListUserAddUser;
    @FXML
    private TableColumn columnListUsersId;
    @FXML
    private TableColumn columnListUserName;
    @FXML
    private TableColumn columnListUsersEmail;
    @FXML
    private TableColumn columnListUserPhoneNumber;
    @FXML
    private TableColumn columnListUserRemove;
}
