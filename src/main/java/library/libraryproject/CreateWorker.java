package library.libraryproject;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import library.libraryproject.libraryInventory.Worker;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CreateWorker {
    private ObservableList<Worker> worker = FXCollections.observableArrayList();
    @FXML
    private Button bottomExitCreate;
    @FXML
    private TextField textCreateUser;
    @FXML
    private TextField textCreatePassword;
    @FXML
    private TextField textCreateId;
    @FXML
    private Button bottonCreateAcount;

    public void goToMenuCreate(ActionEvent actionEvent) throws IOException {
        if(textCreateId.getText().isEmpty() ||
                textCreatePassword.getText().isEmpty() ||
                textCreateUser.getText().isEmpty()) {
            SceneLoader.alertSpam("You are not a Manager!");
        }else{
            worker.add(new Worker(textCreateUser.getText(),
                    textCreatePassword.getText()));
            saveFile(worker);
        }
        SceneLoader.loadScreen("menu.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }

    private static void saveFile(ObservableList<Worker> worker){
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("workers.txt", true)))){
            worker.forEach(u -> pw.println(u.toString()));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void goToMenuExit(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("menu.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }
}
