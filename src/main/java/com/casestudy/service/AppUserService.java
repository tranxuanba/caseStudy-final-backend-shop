package com.casestudy.service;

import com.casestudy.model.LoginUser;
import com.casestudy.repository.IAppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService implements UserDetailsService {
    @Autowired
    IAppUserRepo iAppUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginUser loginUser = iAppUserRepo.findByUsername(username);
        return new User(loginUser.getUsername(), loginUser.getPassword(), loginUser.getRoles());
    }

    public List<LoginUser> getAll(){
        return (List<LoginUser>) iAppUserRepo.findAll();
    }

    public LoginUser findByUserName(String username){
        LoginUser loginUser = iAppUserRepo.findByUsername(username);
        return loginUser;
    }

    public LoginUser save(LoginUser loginUser){
        return iAppUserRepo.save(loginUser);
    }
}
