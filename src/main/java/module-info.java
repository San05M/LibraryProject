module library.libraryproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens library.libraryproject to javafx.fxml;
    exports library.libraryproject;
}