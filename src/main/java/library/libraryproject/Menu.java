package library.libraryproject;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import library.libraryproject.libraryInventory.Manager;
import library.libraryproject.libraryInventory.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller for the main menu.
 * @author sandramoyaortega
 * @version 2
 * @since 1
 */
public class Menu {
    @FXML
    private Button bottomViewUsers;
    @FXML
    private Button bottomViewInventory;
    @FXML
    private Button bottomViewLoans;
    @FXML
    private Button bottomCreateUser;
    @FXML
    private Button bottomExit;

    /**
     * Method to load the screen for go to the CreateWorker.
     */
    public void goToCreateUser(ActionEvent actionEvent) throws IOException {

        if(findPerson()){
            SceneLoader.loadScreen("CreateWorker.fxml",
                    (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
        }
        else{
            SceneLoader.alertSpam("Error. YOU ARE NOT MANAGER!!!");
        }
    }

    /**
     * Method to load the screen for go to the loans list.
     */
    public void goToListLoans(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("ListLoans.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }

    /**
     * Method to load the screen for go to the books list.
     */
    public void goToListBooks(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("ListBooks.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }

    /**
     * Method to load the screen for go to the users list.
     */
    public void goToListUsers(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("ListUsers.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }

    /**
     * Method to close the app.
     */
    public void closeApp(ActionEvent actionEvent) throws IOException {
        Platform.exit();
    }

    /**
     * Method to read the file with the actual loggin and returns the person loggin.
     * @return Person
     */
    private static Person readFilePerson() {
        try {

            String line = Files.readAllLines(Paths.get("actualLogin.txt")).get(0);
            String[] parts = line.split(";");

            return new Person(parts[0], parts[1]);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method to find the person in the list of manager to know if the persons is a manager.
     * @return boolean
     */
    private Boolean findPerson(){
        List<Manager> managers = readFileManager();
        Person p = readFilePerson();

        return managers.stream().anyMatch(m -> m.getName().equals(p.getName()) &&
                m.getPassword().equals(p.getPassword()));
    }

    /**
     * Method to read the file with the manager and save it in the list.
     * @return List<Manager>
     */
    private static List<Manager> readFileManager(){
        try{
            return Files.lines(Paths.get("managers.txt")).
                    map(line -> new Manager(line.split(";")[0],
                    line.split(";")[1])).
                    collect(Collectors.toList());
        }catch (Exception e){
            return null;
        }
    }
}