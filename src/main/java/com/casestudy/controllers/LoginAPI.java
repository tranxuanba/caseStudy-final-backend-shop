package com.casestudy.controllers;

import com.casestudy.model.LoginUser;
import com.casestudy.model.UserRole;
import com.casestudy.model.dto.UserToken;
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
    public UserToken login(@RequestBody LoginUser loginUser){
        try {
            // Tạo ra 1 đối tượng Authentication.
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtService.createToken(authentication);
            LoginUser loginUser1 = appUserService.findByUserName(loginUser.getUsername());
            return new UserToken(loginUser1.getId(),loginUser1.getUsername(),token,loginUser1.getRoles());
        } catch (Exception e) {
            return null;
        }

    }

    @PostMapping("/register")
    public ResponseEntity<LoginUser> register(@RequestBody LoginUser loginUser){
        Set<UserRole> roles = new HashSet<>();
        UserRole userRole = new UserRole();
        userRole.setId(2);
        roles.add(userRole);
        loginUser.setRoles(roles);
       return new ResponseEntity<>(appUserService.save(loginUser), HttpStatus.OK);
    }
}
