package com.casestudy.service;

import com.casestudy.repository.IAppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService implements IAppUserService {
    @Autowired
    IAppUserRepo iAppUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginUser loginUser = iAppUserRepo.findByUsername(username);
        return new User(loginUser.getUsername(), loginUser.getPassword(), loginUser.getRoles());
    }

    public List<LoginUser> getAll()  {
        return (List<LoginUser>) iAppUserRepo.findAll();
    }

    public LoginUser findByUserName(String username){
        LoginUser loginUser = iAppUserRepo.findByUsername(username);
        return loginUser;
    }

    @Override
    public Page<LoginUser> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Iterable<LoginUser> findAll() {
        return iAppUserRepo.findAll();
    }

    @Override
    public Optional<LoginUser> findById(Long id) {
        return iAppUserRepo.findById(id);
    }

    public LoginUser save(LoginUser loginUser){
        return iAppUserRepo.save(loginUser);
    }

    @Override
    public void remove(Long id) {

    }

    public LoginUser getCurrentUser() {
        LoginUser loginUser;
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

    @Override
    public Optional<LoginUser> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Boolean existsByUsername(String username) {
        return null;
    }

    @Override
    public Iterable<LoginUser> getAllUsers() {
        return iAppUserRepo.findAll();
    }
//    public LoginUser getUserByUserName(String username) {
//        return appUserRepository.getLoginUserByUsername(username);
//    }
}
