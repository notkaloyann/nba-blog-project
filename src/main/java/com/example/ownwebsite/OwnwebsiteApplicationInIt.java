package com.example.ownwebsite;

import com.example.ownwebsite.services.TeamService;
import com.example.ownwebsite.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OwnwebsiteApplicationInIt implements CommandLineRunner {

    private final UserService userService;
    private final TeamService teamService;

    public OwnwebsiteApplicationInIt(UserService userService, TeamService teamService) {
        this.userService = userService;
        this.teamService = teamService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.userService.seedUsers();
        this.teamService.seedTeams();

    }




}
