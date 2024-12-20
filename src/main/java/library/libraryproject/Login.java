package library.libraryproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import library.libraryproject.libraryInventory.Manager;
import library.libraryproject.libraryInventory.Person;
import library.libraryproject.libraryInventory.Worker;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller for the login screen of the application.
 * @author sandramoyaortega
 * @version 2
 * @since 1
 */
public class Login {
    @FXML
    private TextField textUserNameId;
    @FXML
    private TextField textPassword;
    @FXML
    private Button bottomAccessLogin;

    /**
     * Method to login process and navigate to the main menu.
     */
    public void goToMenu(ActionEvent actionEvent) throws IOException {

        if (textUserNameId.getText().isEmpty() ||
                textPassword.getText().isEmpty()) {
            SceneLoader.alertSpam("Error. Field empty.");
        } else {
            if(findPerson(textUserNameId.getText(),textPassword.getText())){
                Person p = new Person(textUserNameId.getText(), textPassword.getText());
                savePerson(p);
                SceneLoader.loadScreen("menu.fxml",
                        (Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
            }
            else{
                SceneLoader.alertSpam("Error. Incorrect user. Try again.");
            }
        }
    }

    /**
     * Method to provided user credentials.
     * @return boolean
     */
    private Boolean findPerson(String name, String password){
        List<Worker> workers = readFileWorker();
        List<Manager> managers = readFileManager();
        return (workers.stream().
                anyMatch(p -> (p.getName().trim().equals(name.trim()) &&
                        p.getPassword().equals(password))) ||
                (managers.stream().
                anyMatch(p -> (p.getName().trim().equals(name.trim()) &&
                        p.getPassword().equals(password)))));
    }

    /**
     * Method to read the file with the worker and save it in the list.
     * @return List<Worker>
     */
    private List<Worker> readFileWorker() {
        try {
            return Files.lines(Paths.get("workers.txt"))
                    .map(line -> {
                        String[] parts = line.split(";");
                        return new Worker(parts[0], parts[1]);})
                        .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method to read the file with the manager and save it in the list.
     * @return List<Manager>
     */
    private List<Manager> readFileManager() {
        try {
            return Files.lines(Paths.get("managers.txt"))
                    .map(line -> {
                        String[] parts = line.split(";");
                        return new Manager(parts[0], parts[1]);})
                        .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method to save the details of the person login.
     */
    private void savePerson(Person p) {
        try(PrintWriter pw = new PrintWriter("actualLogin.txt")){
            pw.println(p.toString());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

