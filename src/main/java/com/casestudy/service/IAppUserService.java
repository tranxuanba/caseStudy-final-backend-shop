package com.casestudy.service;

import com.casestudy.model.LoginUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IAppUserService extends IService<LoginUser> , UserDetailsService {
    Optional<LoginUser> findByUsername(String username);
    Boolean existsByUsername(String username);
    Iterable<LoginUser> getAllUsers();
}
