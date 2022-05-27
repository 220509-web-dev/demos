package dev.ranieri.app;

public class User {

    @Email
    String username;
    String firstName;
    String lastName;

    public User(String username, String firstName, String lastName) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        UserValidator.validate(this);
    }
}
