package library.libraryproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import library.libraryproject.libraryInventory.Book;
import library.libraryproject.libraryInventory.Loan;
import library.libraryproject.libraryInventory.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
/**
 * Controller class for managing loan operations in the library system.
 * This class controls the User Interface components related to loan management and interacts with User, Book, and
 * Loan classes.
 *
 * @author sandramoyaortega
 * @version 3.0
 * @since 1.0
 */
public class ListLoans implements Initializable {
    @FXML
    private TextField textLoanContact;
    @FXML
    private Button buttonAddLoan;
    @FXML
    private TableView tableListLoans;
    @FXML
    private Button buttonListLoansAddExit;
    @FXML
    private Button buttonListLoansSearch;
    @FXML
    private TextField textListLoansName;
    @FXML
    private TextField textListLoansBook;
    @FXML
    private TextField textListLoansDataLoan;
    @FXML
    private TextField textListLoansDataCheck;
    @FXML
    private Button buttonListLoansAddLoan;
    @FXML
    private TableColumn columnListLoansName;
    @FXML
    private TableColumn columnListLoansBookName;
    @FXML
    private TableColumn columnListLoansDataLoan;
    @FXML
    private TableColumn columnListLoansDataCheck;
    @FXML
    private TableColumn columnListLoansContact;
    @FXML
    private TableColumn columnListLoansRemove;

    /**
     * Initializes the ListLoans.
     * Set the cells with the name of the getters.
     * Reads loan data from file and populates the TableView only with existing loans.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.columnListLoansName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        this.columnListLoansBookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        this.columnListLoansDataLoan.setCellValueFactory(new PropertyValueFactory<>("loanBook"));
        this.columnListLoansDataCheck.setCellValueFactory(new PropertyValueFactory<>("checkBook"));

        List<Loan> loans = readLoansFromFile();
        this.tableListLoans.getItems().addAll(loans);
    }

    /**
     * Loads the main menu screen.
     *
     * @param actionEvent Action event activated by the button click
     */
    public void goToMenu(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("menu.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }
    /**
     * Adds a new loan.
     * If any required field is empty, alert is activated.
     * If the user or book is not found, alert is activated.
     *
     * @param actionEvent Action event activated by the button click
     */
    public void addLoan(ActionEvent actionEvent) {
        if (textListLoansName.getText().isEmpty() ||
                textListLoansBook.getText().isEmpty() ||
                textLoanContact.getText().isEmpty() ||
                textListLoansDataLoan.getText().isEmpty() ||
                textListLoansDataCheck.getText().isEmpty()) {

            SceneLoader.alertSpam();
        } else {
            String userName = textListLoansName.getText();
            String bookName = textListLoansBook.getText();
            LocalDate loanBook = LocalDate.parse(textListLoansDataLoan.getText());
            LocalDate checkBook = LocalDate.parse(textListLoansDataCheck.getText());

            User user = findUserByName(userName);
            Book book = findBookByName(bookName);

            if (user == null || book == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error adding loan");
                alert.setContentText("User or book not found");
                alert.showAndWait();
            } else {
                Loan loan = new Loan(user, book, loanBook, checkBook);
                tableListLoans.getItems().add(loan);
                saveLoanToFile(loan);
            }
        }
    }

    /**
     * Finds a user by their name.
     *
     * @param name The name of the user to find
     * @return The User object if found or null
     */
    private User findUserByName(String name) {
        List<User> users = readFileUsers();
        return users.stream()
                .filter(user -> user.getName().trim().equals(name.trim()))
                .findFirst().orElse(null);
    }

    /**
     * Finds a book by their name.
     *
     * @param name The name of the user to find
     * @return The Book object if found or null
     */
    private Book findBookByName(String name) {
        List<Book> books = readFileBooks();
        return books.stream()
                .filter(book -> book.getName().trim().equals(name.trim()))
                .findFirst().orElse(null);
    }

    /**
     * Reads user from file and returns a list of users.
     *
     * @return List of User objects
     */
    private List<User> readFileUsers() {
        try {
            return Files.lines(Paths.get("user.txt"))
                    .map(line -> {
                        String[] parts = line.split(";");
                        return new User(parts[0], parts[1], parts[2], parts[3]);
                    }).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Reads book from file and returns a list of books.
     *
     * @return List of book objects
     */
    private List<Book> readFileBooks() {
        try {
            return Files.lines(Paths.get("books.txt"))
                    .map(line -> {
                        String[] parts = line.split(";");
                        return new Book(parts[0], parts[1], parts[2], parts[3]);
                    })
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Saves a loan to a file.
     *
     * @param loan Save
     */
    private void saveLoanToFile(Loan loan) {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("loans.txt", true)))) {
            pw.println();
            pw.println(loan.toString());
        } catch (IOException e) {
            throw new RuntimeException("Error adding loan to file", e);
        }
    }

    /**
     * Reads loan data from file and returns a list.
     *
     * @return List objects
     */
    private List<Loan> readLoansFromFile() {
        try {
            return Files.lines(Paths.get("loans.txt"))
                    .map(line -> {
                        String[] parts = line.split(";");
                        User user = findUserByName(parts[0]);
                        Book book = findBookByName(parts[1]);
                        LocalDate loanBook = LocalDate.parse(parts[2]);
                        LocalDate returnDate = LocalDate.parse(parts[3]);
                        return new Loan(user, book, loanBook, returnDate);
                    }).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}