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

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Controller class for creating new worker accounts.
 * @author sandramoyaortega
 * @version 1.0
 * @since 1.0
 */
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

    /**
     * Go to main menu.
     */
    public void goToMenuExit(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("menu.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }

    /**
     * Handles the action event to navigate back to the main menu after creating a worker account.
     * If the password or username fields are empty, an alert is shown.
     * A new worker account is created and saved to the file.
     */
    public void goToMenuCreate(ActionEvent actionEvent) throws IOException {
        if(textCreatePassword.getText().isEmpty() ||
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

    /**
     * Save the new worker on txt.
     */
    private static void saveFile(ObservableList<Worker> worker){
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("workers.txt", true)))){
            worker.forEach(u -> pw.println(u.toString()));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}