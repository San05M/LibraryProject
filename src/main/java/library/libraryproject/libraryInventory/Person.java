package library.libraryproject.libraryInventory;
/**
 * Class to define the persons
 * @author sandramoyaortega
 * @version 3
 * @since 1
 */
public class Person {
    private String name;
    private String password;
    /**
     * Constructor with parameters
     * @param name String with the name
     * @param password  String with the password
     */
    public Person(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString(){
        return name + ';' + password;
    }
}
