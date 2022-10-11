package com.casestudy.service;

import com.casestudy.model.User;
import com.casestudy.repository.IAppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
        User loginUser = iAppUserRepo.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(loginUser.getUsername(), loginUser.getPassword(), loginUser.getRoles());
    }

    public List<User> getAll(){
        return (List<User>) iAppUserRepo.findAll();
    }

    public User findByUserName(String username){
        User loginUser = iAppUserRepo.findByUsername(username);
        return loginUser;
    }

    public User save(User loginUser){
        return iAppUserRepo.save(loginUser);
    }
    public User getCurrentUser() {
        User loginUser;
        String name;
        Object ob = SecurityContextHolder.getContext().getAuthentication();
        if (ob instanceof UserDetails) {
            name = ((UserDetails)ob).getUsername();
        }else {
            name = ob.toString();
        }
        loginUser = this.findByUserName(name);
        return loginUser;
    }
//    public LoginUser getUserByUserName(String username) {
//        return appUserRepository.getLoginUserByUsername(username);
//    }
}
