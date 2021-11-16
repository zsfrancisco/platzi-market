package com.platzi.market.domain.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlatziUserDetailService implements UserDetailsService {
    private static List<User> users = new ArrayList<>();

    public PlatziUserDetailService() {
        users.add(new User("francisco", "{noop}platzi", new ArrayList<>()));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userFound = users.stream().filter(u -> u.getUsername().equals(username)).findAny();
        return userFound.map(user ->
                        new User(userFound.get().getUsername(),
                                userFound.get().getPassword(),
                                userFound.get().getAuthorities()))
                .orElseThrow(() ->
                        new UsernameNotFoundException("Username " + username + " not found."));
    }
}
