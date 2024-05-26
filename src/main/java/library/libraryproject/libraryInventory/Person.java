package library.libraryproject.libraryInventory;
/**
 * Class to define the persons
 * @author sandramoyaortega
 * @version 1
 * @since 1
 */
public class Person {
    private String name;
    private String id;
    private String password;
    /**
     * Constructor with parameters
     * @param name String with the name
     * @param id String with the id of user
     * @param password  String with the password
     */
    public Person(String name, String id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString(){
        return name + ';' + id + ';' + password;
    }
}
