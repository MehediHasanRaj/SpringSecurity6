package com.raj.springsecurity6.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.raj.springsecurity6.model.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
