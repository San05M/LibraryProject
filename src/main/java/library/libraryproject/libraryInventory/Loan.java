package library.libraryproject.libraryInventory;
import java.time.LocalDate;

/**
 * Class to define the Loan
 * @author sandramoyaortega
 * @version 1
 * @since 1
 */
public class Loan {
    private User user;
    private Book book;
    private LocalDate loanBook;
    private LocalDate checkBook;
    /**
     * Constructor with parameters
     * @param user Object type user for the loan
     * @param book Object type book for the loan
     * @param loanBook  Date for the loan date (dd/mm/yyyy)
     * @param checkBook  Date for the check date (dd/mm/yyyy)
     */
    public Loan(User user, Book book, LocalDate loanBook, LocalDate checkBook){
        this.user = user;
        this.book = book;
        this.loanBook = loanBook;
        this.checkBook = checkBook;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getLoanBook() {
        return loanBook;
    }

    public void setLoanBook(LocalDate loanBook) {
        this.loanBook = loanBook;
    }

    public LocalDate getCheckBook() {
        return checkBook;
    }

    public void setCheckBook(LocalDate checkBook) {
        this.checkBook = checkBook;
    }

    public String getUserName() {
        return user.getName();
    }
    public String getBookName() {
        return book.getName();
    }
    public String toString() {
        return user.getName() + ";" + book.getName() + ";" + loanBook + ";" + checkBook;
    }
}
