package library.libraryproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneLoader {
    public static void loadScreen(String viewPath, Stage stage)
            throws IOException {
        Parent root = FXMLLoader.load(
                HelloApplication.class.getResource(viewPath));
        Scene viewScene = new Scene(root);
        stage.setScene(viewScene);
        stage.show();
    }
}
