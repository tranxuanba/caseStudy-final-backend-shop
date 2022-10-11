package com.casestudy.service;

import com.casestudy.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends GenericService<User>, UserDetailsService {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Iterable<User> getAllUsers();
}
