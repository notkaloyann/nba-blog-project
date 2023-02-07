package com.example.ownwebsite.services;

import com.example.ownwebsite.models.entities.User;
import com.example.ownwebsite.models.service.UserRegistrationServiceModel;
import com.example.ownwebsite.models.view.UserViewModel;

public interface UserService {
    void registerUser(UserRegistrationServiceModel userServiceModel);
    UserRegistrationServiceModel returnUserByUsername(String username);

    void seedUsers();
    boolean alreadyExist(String username);
    User returnUserEntity(String username);
    UserViewModel returnUserViewModel(String username);



}
