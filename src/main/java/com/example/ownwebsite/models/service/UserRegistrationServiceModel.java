package com.example.ownwebsite.models.service;

import com.example.ownwebsite.models.entities.Role;

public class UserRegistrationServiceModel {
    private String username;
    private String password;
    private String email;
    private Role role;

    public UserRegistrationServiceModel() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
