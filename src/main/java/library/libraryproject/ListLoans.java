package library.libraryproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ListLoans {
    @FXML
    private Button buttonListLoansAddExit;
    @FXML
    private Button buttonListLoansSearch;
    @FXML
    private TextField textListLoansName;
    @FXML
    private TextField textListLoansBook;
    @FXML
    private TextField textListLoansDataLoan;
    @FXML
    private TextField textListLoansDataCheck;
    @FXML
    private Button buttonListLoansAddLoan;
    @FXML
    private TableColumn columnListLoansName;
    @FXML
    private TableColumn columnListLoansBookName;
    @FXML
    private TableColumn columnListLoansDataLoan;
    @FXML
    private TableColumn columnListLoansDataCheck;
    @FXML
    private TableColumn columnListLoansContact;
    @FXML
    private TableColumn columnListLoansRemove;

    public void goToCreateLoan(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("CreateLoan.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }

    public void goToMenu(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("menu.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }
}