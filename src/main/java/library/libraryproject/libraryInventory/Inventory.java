package library.libraryproject.libraryInventory;

import java.util.ArrayList;
import java.util.Map;

public class Inventory {

    private ArrayList<Book> books;
    private ArrayList<Book> availableBooks;
    private ArrayList<Book> loansBooks;
    private Map<String, ArrayList<Book>> loansUsersBook;

    public Inventory(ArrayList<Book> books, ArrayList<Book> availableBooks, ArrayList<Book> loansBooks, Map<String,
            ArrayList<Book>> loansUsersBook){
        this.books = books;
        this.availableBooks = availableBooks;
        this.loansBooks = loansBooks;
        this.loansUsersBook = loansUsersBook;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(ArrayList<Book> availableBooks) {
        this.availableBooks = availableBooks;
    }

    public ArrayList<Book> getLoansBooks() {
        return loansBooks;
    }

    public void setLoansBooks(ArrayList<Book> loansBooks) {
        this.loansBooks = loansBooks;
    }

    public Map<String, ArrayList<Book>> getLoansUsersBook() {
        return loansUsersBook;
    }

    public void setLoansUsersBook(Map<String, ArrayList<Book>> loansUsersBook) {
        this.loansUsersBook = loansUsersBook;
    }
    public void SearchForBook(){

    }
    public void addBook(){

    }
    public void deleteBook(){

    }
    public void lendBook(){

    }
    public void showLendList(){

    }
    public void showAvailableList(){

    }
    public void showUserList() {

    }
}
