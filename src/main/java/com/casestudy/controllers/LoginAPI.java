package com.casestudy.controllers;

import com.casestudy.model.User;
import com.casestudy.model.Role;
import com.casestudy.service.AppUserService;
import com.casestudy.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin("*")
public class LoginAPI {
    @Autowired
    JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    AppUserService appUserService;


    @PostMapping("/login")
    public ResponseEntity<UserToken>  login(@RequestBody User loginUser){
        try {
            // Tạo ra 1 đối tượng Authentication.
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtService.createToken(authentication);
            User loginUser1 = appUserService.findByUserName(loginUser.getUsername());
            UserToken userToken1 = new UserToken(loginUser1.getId(),loginUser1.getUsername(),token,loginUser1.getRoles());
            return new ResponseEntity<>(userToken1,HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User loginUser){
        Set<Role> roles = new HashSet<>();
        Role userRole = new Role();
        userRole.setId(2);
        roles.add(userRole);
        loginUser.setRoles(roles);
       return new ResponseEntity<>(appUserService.save(loginUser), HttpStatus.OK);
    }
}
