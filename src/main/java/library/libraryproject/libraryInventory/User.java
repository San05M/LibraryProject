package library.libraryproject.libraryInventory;
/**
 * Class to define the users of the library
 * @author sandramoyaortega
 * @version 1.1
 * @since 1
 */
public class User {
    private String name;
    private String id;
    private String email;
    private String phoneNumber;
    /**
     * Constructor with parameters
     * @param name String with the name
     * @param id String with the id of user
     * @param email  String with the personal email
     * @param phoneNumber int with the phone number
     */
    public User(String name, String id, String email, String phoneNumber){
        this.name = name;
        this.id = id;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString(){
        return name + ";" + id + ";" + email + ";" + phoneNumber;
    }
}
