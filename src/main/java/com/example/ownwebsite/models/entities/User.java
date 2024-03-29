package com.example.ownwebsite.models.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String username;
    private String password;
    private String email;
    private String firstAndLastName;
    private String bio;
    private List<Role> role = new ArrayList<>();

    public User() {
    }

    @Column(name = "first_and_last_name")
    @Pattern(regexp = "[a-zA-Z]+\\s+[a-zA-Z]+")
    public String getFirstAndLastName() {
        return firstAndLastName;
    }

    public User setFirstAndLastName(String firstAndLastName) {
        this.firstAndLastName = firstAndLastName;
        return this;
    }

    @Column(name = "bio")
    public String getBio() {
        return bio;
    }

    public User setBio(String bio) {
        this.bio = bio;
        return this;
    }

    @Column(name = "username",nullable = false,unique = true)
    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    @Column(name = "email", nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public List<Role> getRole() {
        return role;
    }

    public User setRole(List<Role> role) {
        this.role = role;
        return this;
    }
}
