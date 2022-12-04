package com.example.ownwebsite.services.impl;

import com.example.ownwebsite.models.entities.Role;
import com.example.ownwebsite.models.entities.RoleNameEnum;
import com.example.ownwebsite.models.entities.User;
import com.example.ownwebsite.models.service.UserRegistrationServiceModel;
import com.example.ownwebsite.repositories.UserRepository;
import com.example.ownwebsite.security.DemoUserDetailsService;
import com.example.ownwebsite.services.RoleService;
import com.example.ownwebsite.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final DemoUserDetailsService demoUserDetailsService;



    public UserServiceImpl(UserRepository userRepository, RoleService roleService, ModelMapper modelMapper, PasswordEncoder passwordEncoder, DemoUserDetailsService demoUserDetailsService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.demoUserDetailsService = demoUserDetailsService;
    }


    @Override
    public void registerUser(UserRegistrationServiceModel userServiceModel) {
        User user = this.modelMapper.map(userServiceModel,User.class);
        Role role = this.roleService.returnRoleFromName(RoleNameEnum.USER);
        user.setRole(List.of(role));
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        UserDetails userDetails = this.demoUserDetailsService.loadUserByUsername(user.getUsername());


        Authentication authentication = new UsernamePasswordAuthenticationToken(
        userDetails,user.getPassword(),userDetails.getAuthorities()
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

    }

    @Override
    public UserRegistrationServiceModel returnUserByUsername(String username) {

        Optional <User> unmapperUser = this.userRepository.findUserByUsername(username);

        return this.modelMapper.map(unmapperUser,UserRegistrationServiceModel.class);
    }


    @Override
    public void seedUsers() {
        if (this.roleService.isEmpty()) {
            Role admin = new Role().setRoleNameEnum(RoleNameEnum.ADMIN);
            Role user = new Role().setRoleNameEnum(RoleNameEnum.USER);
            this.roleService.inItRoles(List.of(admin, user));


            User adminUser = new User().setUsername("notkaloyan")
                    .setPassword(this.passwordEncoder.encode("verySecret"))
                    .setEmail("adminmail@mail.bg");
            adminUser.setRole(List.of(admin,user));
            User regularUser = new User().setUsername("reggie")
                    .setPassword(this.passwordEncoder.encode("notVerySecret"))
                    .setEmail("usermail@mail.bg");
            regularUser.setRole(List.of(user));


            this.userRepository.saveAll(List.of(adminUser, regularUser));
        }
    }

    @Override
    public boolean alreadyExist(String username) {
        return this.userRepository.findUserByUsername(username).isPresent();
    }

    @Override
    public User returnUserEntity(String username) {
        return this.userRepository.findUserByUsername(username).orElse(null);
    }


}
