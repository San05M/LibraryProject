package library.libraryproject;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import library.libraryproject.libraryInventory.Manager;
import library.libraryproject.libraryInventory.Person;
import library.libraryproject.libraryInventory.User;
import library.libraryproject.libraryInventory.Worker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

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

    public void goToCreateUser(ActionEvent actionEvent) throws IOException {

        if(findPerson()){
            SceneLoader.loadScreen("CreateWorker.fxml",
                    (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
        }
        else{
            SceneLoader.alertSpam("Error. YOU ARE NOT MANAGER!!!");
        }
    }

    public void goToListLoans(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("ListLoans.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }

    public void goToListBooks(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("ListBooks.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }

    public void goToListUsers(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("ListUsers.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }

    public void closeApp(ActionEvent actionEvent) throws IOException {
        Platform.exit();
    }

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

    private Boolean findPerson(){
        List<Manager> managers = readFileManager();
        Person p = readFilePerson();

        return managers.stream().anyMatch(m -> m.getName().equals(p.getName()) && m.getPassword().equals(p.getPassword()));
    }
    private static List<Manager> readFileManager(){
        try{
            return Files.lines(Paths.get("managers.txt")).map(line -> new Manager(line.split(";")[0],
                    line.split(";")[1])).collect(Collectors.toList());
        }catch (Exception e){
            return null;
        }
    }
}
