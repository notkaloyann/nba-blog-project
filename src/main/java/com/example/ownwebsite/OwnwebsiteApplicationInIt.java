package com.example.ownwebsite;

import com.example.ownwebsite.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OwnwebsiteApplicationInIt implements CommandLineRunner {

    private final UserService userService;

    public OwnwebsiteApplicationInIt(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.userService.seedUsers();



    }
}
