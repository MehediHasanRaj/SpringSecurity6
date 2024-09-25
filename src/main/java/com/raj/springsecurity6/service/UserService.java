package com.raj.springsecurity6.service;

import com.raj.springsecurity6.model.Users;
import com.raj.springsecurity6.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import com.raj.springsecurity6.config.SecurityConfig.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public UserService() {
    }

    public Users register(Users user) {
        user.setPassword(this.encoder.encode(user.getPassword()));
        this.repo.save(user);
        return user;
    }

    public String varify(Users user) {
        Authentication authentication =authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(user.getUsername());
        }
        return "fail";
    }
}

