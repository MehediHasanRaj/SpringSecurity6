package com.raj.springsecurity6.service;

import com.raj.springsecurity6.model.UserPrincipal;
import com.raj.springsecurity6.model.Users;


import com.raj.springsecurity6.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    public MyUserDetailsService() {
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = this.userRepo.findByUsername(username);
        if (user == null) {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("user not found");
        } else {
            return new UserPrincipal(user);
        }
    }
}