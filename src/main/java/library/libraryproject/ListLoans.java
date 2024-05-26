package library.libraryproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private TextField textBookDelete;
    @FXML
    private Button buttonDelete;
    @FXML
    private TextField textLoanContact;
    @FXML
    private Button buttonAddLoan;
    @FXML
    private TableView tableListLoans;
    @FXML
    private TextField textListLoansName;
    @FXML
    private TextField textListLoansBook;
    @FXML
    private TextField textListLoansDataLoan;
    @FXML
    private TextField textListLoansDataCheck;
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
     * Navigates back to the main menu.
     */
    public void goToMenu(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScreen("menu.fxml",
                (Stage)((Node) actionEvent.getSource()).getScene().getWindow());
    }

    /**
     * Adds a new loan.
     * If any required field is empty, alert is activated.
     * If the user or book is not found, alert is activated.
     */
    public void addLoan(ActionEvent actionEvent) {
        if (textListLoansName.getText().isEmpty() ||
                textListLoansBook.getText().isEmpty() ||
                textListLoansDataLoan.getText().isEmpty() ||
                textListLoansDataCheck.getText().isEmpty()) {

            SceneLoader.alertSpam("Error. Field empty.");
        } else {
            String userName = textListLoansName.getText();
            String bookName = textListLoansBook.getText();
            LocalDate loanBook = LocalDate.parse(textListLoansDataLoan.getText());
            LocalDate checkBook = LocalDate.parse(textListLoansDataCheck.getText());

            User user = findUserByName(userName);
            Book book = findBookByName(bookName);

            if(user == null || book == null) {
                SceneLoader.alertSpam("User or book not found");
            } else {
                if(book.getAvailable().equals("yes")){
                    book.setAvailable("no");
                    Loan loan = new Loan(user, book, loanBook, checkBook);
                    tableListLoans.getItems().add(loan);
                    saveLoanToFile(loan);
                    updateBookFile(book, "No");
                }else{
                    SceneLoader.alertSpam("Book not available.");
                }
            }
        }
    }

    /**
     * Delete the load and add available to the book.
     */
    public void deleteLoan(ActionEvent actionEvent) {
        if(textBookDelete.getText().isEmpty()){
            SceneLoader.alertSpam("Error: Field empty.");
        }else{
            String name = textBookDelete.getText();
            List<Loan> loans = readLoansFromFile();
            Loan loanDelete = loans.stream()
                    .filter(loan -> loan.getBookName().trim().equals(name.trim()))
                    .findFirst().orElse(null);

            if(loanDelete == null){
                SceneLoader.alertSpam("Error: loan not found.");
            }else{
                loans.remove(loanDelete);
                saveLoanToFileAftherDelete(loans);
                Book book = findBookByName(name);
                if(book == null){
                    SceneLoader.alertSpam("Error: book not found.");
                }else{
                    book.setAvailable("yes");
                    updateBookFile(book, "yes");
                }
                updateTable(loans);
            }
        }
    }

    /**
     * Finds a user by their name.
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
     * @return The Book object if found or null
     */
    private Book findBookByName(String name) {
        List<Book> books = readFileBooks();
        return books.stream()
                .filter(book -> book.getName().trim().equals(name.trim()))
                .findFirst().orElse(null);
    }

    /**
     * Saves a loan to a file.
     */
    private void saveLoanToFile(Loan loan) {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("loans.txt", true)))) {
            pw.println(loan.toString());
        } catch (IOException e) {
            throw new RuntimeException("Error adding loan to file", e);
        }
    }

    /**
     * Saves a loan to a file afther delete.
     */
    private void saveLoanToFileAftherDelete(List<Loan> loans){
        try(PrintWriter pw = new PrintWriter("loans.txt")){
            loans.forEach(l -> pw.println(l.toString()));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Reads loan data from file and returns a list.
     *
     * @return the loan list
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
                    })
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
                    })
                    .collect(Collectors.toList());
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
                        return new Book(parts[0], parts[1], parts[2], parts[3], parts[4]);
                    })
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Update books.txt add the available
     */
    private void updateBookFile(Book b, String text){
        try {
            List<String> lines = Files.readAllLines(Paths.get("books.txt"));
            for(int i=0; i < lines.size();i++){
                    String[] partslines=lines.get(i).split(";");
                    if(b.getName().equals(partslines[0])){
                        partslines[4] = text;
                        lines.set(i, String.join(";",partslines));
                    }
            }
            Files.write(Paths.get("books.txt"), lines);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Update table Loans
     */
    private void updateTable(List<Loan> loans){
        ObservableList<Loan> updateloans = FXCollections.observableArrayList(loans);
        this.tableListLoans.setItems(updateloans);
    }
}