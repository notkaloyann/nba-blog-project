package com.example.ownwebsite.models.view;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserViewModel {

    private String username;
    private String email;
    private String firstAndLastName;
    private String bio;

    public UserViewModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @NotNull
    @Email
    public String getEmail() {
        return email;
    }

    public UserViewModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @Pattern(regexp = "[a-zA-Z]+\\s+[a-zA-Z]+")
    public String getFirstAndLastName() {
        return firstAndLastName;
    }

    public UserViewModel setFirstAndLastName(String firstAndLastName) {
        this.firstAndLastName = firstAndLastName;
        return this;
    }

    public String getBio() {
        return bio;
    }

    public UserViewModel setBio(String bio) {
        this.bio = bio;
        return this;
    }
}
