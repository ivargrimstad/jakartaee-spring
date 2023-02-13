package dukes.lib;

import javax.validation.constraints.Email;

public class User {

    @Email
    private String email;

    public User() {
    }

    public User(String email) {
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
