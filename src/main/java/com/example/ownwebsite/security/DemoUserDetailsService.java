package com.example.ownwebsite.security;

import com.example.ownwebsite.models.entities.User;
import com.example.ownwebsite.repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DemoUserDetailsService implements UserDetailsService {


    private final UserRepository userRepository;

    public DemoUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         User user = userRepository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User %s not found.",username)));

    return mapToUserDetails(user);
    }

    private UserDetails mapToUserDetails(User user){

        List<SimpleGrantedAuthority> authorities = user.getRole()
                .stream()
                .map(x -> new SimpleGrantedAuthority("ROLE_" + x.getRoleNameEnum().name()))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),user.getPassword(),authorities);
    }

}
