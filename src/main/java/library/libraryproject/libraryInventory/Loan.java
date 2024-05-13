package library.libraryproject.libraryInventory;
import java.util.Date;
public class Loan {
    private User user;
    private Book book;
    private Date loanBook;
    private Date checkBook;

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
