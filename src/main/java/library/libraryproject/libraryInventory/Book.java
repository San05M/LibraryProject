package library.libraryproject.libraryInventory;
/**
 * Class to define book information
 * @author sandramoyaortega
 * @version 1
 * @since 1
 */
public class Book {
    private String name;
    private String author;
    private String genre;
    private String id;
    /**
     * Constructor with parameters
     * @param name A String with the book name
     * @param author A String with author name
     * @param genre A String with the genre book
     */
    public Book(String name, String author, String genre, String id) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return name + ";" + author + ";" + genre + ";" + id;
    }
}
