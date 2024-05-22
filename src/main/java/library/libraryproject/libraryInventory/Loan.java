package library.libraryproject.libraryInventory;
import java.util.Date;

/**
 * Class to define the Loan
 * @author sandramoyaortega
 * @version 1
 * @since 1
 */
public class Loan {
    private User user;
    private Book book;
    private Date loanBook;
    private Date checkBook;
    /**
     * Constructor with parameters
     * @param user Object type user for the loan
     * @param book Object type book for the loan
     * @param loanBook  Date for the loan date (dd/mm/yyyy)
     * @param checkBook  Date for the check date (dd/mm/yyyy)
     */
    public Loan(User user, Book book, Date loanBook, Date checkBook){
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

    public Date getLoanBook() {
        return loanBook;
    }

    public void setLoanBook(Date loanBook) {
        this.loanBook = loanBook;
    }

    public Date getCheckBook() {
        return checkBook;
    }

    public void setCheckBook(Date checkBook) {
        this.checkBook = checkBook;
    }
}
