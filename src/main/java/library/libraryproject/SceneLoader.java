package library.libraryproject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class SceneLoader {
    public static void loadScreen(String viewPath, Stage stage)
            throws IOException {
        Parent root = FXMLLoader.load(
                Objects.requireNonNull(HelloApplication.class.getResource(viewPath)));
        Scene viewScene = new Scene(root);
        stage.setScene(viewScene);
        stage.show();
    }
}