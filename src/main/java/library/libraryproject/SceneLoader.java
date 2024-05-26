package library.libraryproject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;
/**
 * Utility class for loading FXML views and alert dialogs.
 * @author sandramoyaortega
 * @version 2
 * @since 1
 */

public class SceneLoader {
    /**
     * Loads the specified FXML view.
     *
     * @param viewPath The path to the FXML file representing the view.
     * @param stage    The stage where the view will be loaded.
     */

    public static void loadScreen(String viewPath, Stage stage)
            throws IOException {
        Parent root = FXMLLoader.load(
                Objects.requireNonNull(HelloApplication.class.getResource(viewPath)));
        Scene viewScene = new Scene(root);
        stage.setScene(viewScene);
        stage.show();
    }

    /**
     * Displays alert dialog with the error message.
     *
     * @param text The error message.
     */
    public static void alertSpam(String text){
        Alert dialog = new Alert(Alert.AlertType.ERROR);
        dialog.setTitle("Error");
        dialog.setHeaderText("Error");
        dialog.setContentText(text);
        dialog.showAndWait();
    }
}