module library.libraryproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens library.libraryproject to javafx.fxml;
    opens library.libraryproject.libraryInventory;
    exports library.libraryproject;
}