package se.iths.petstore;

public class UserPetStoreClient {

    private int id;
    private String username;
    private String firstname;

    public UserPetStoreClient(int id, String username, String firstname, String lastname, String email, String password, String phone, String userstatus) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userstatus = userstatus;
    }

    private String lastname;
    private String email;
    private String password;
    private String phone;
    private String userstatus;

}


