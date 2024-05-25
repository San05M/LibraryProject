package library.libraryproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import library.libraryproject.libraryInventory.Person;
import library.libraryproject.libraryInventory.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Login {
    @FXML
    private TextField textUserNameId;
    @FXML
    private TextField textPassword;
    @FXML
    private Button bottomAccessLogin;

    public void goToMenu(ActionEvent actionEvent) throws IOException {

        if (textUserNameId.getText().isEmpty() ||
                textPassword.getText().isEmpty()) {
            SceneLoader.alertSpam();
        } else {
            if(findPerson(textUserNameId.getText(),textPassword.getText())){
                SceneLoader.loadScreen("menu.fxml",
                        (Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
            }
            else{
                Alert dialog = new Alert(Alert.AlertType.ERROR);
                dialog.setTitle("Error");
                dialog.setHeaderText("Error adding data");
                dialog.setContentText("Incorrect. Try Again.");
                dialog.showAndWait();
            }

        }
    }

    private Boolean findPerson(String name, String password){
        List<Person> persons = readFilePersons();
        return persons.stream().anyMatch(p -> p.getName().trim().equals(name.trim()) && p.getPassword().equals(password));
    }
    private List<Person> readFilePersons() {
        try {
            return Files.lines(Paths.get("persons.txt"))
                    .map(line -> {
                        String[] parts = line.split(";");
                        return new Person(parts[0], parts[1], parts[2]);
                    }).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

