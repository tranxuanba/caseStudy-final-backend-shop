package com.casestudy.controller;

import com.casestudy.jwt.JwtService;
import com.casestudy.jwt.reponse.JwtResponse;
import com.casestudy.model.dto.LoginForm;
import com.casestudy.model.dto.SignUpForm;
import com.casestudy.model.entity.User;
import com.casestudy.repository.RoleRepository;
import com.casestudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    UserService userService;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpForm signUpForm) {
        if(userService.existsByUsername(signUpForm.getUsername())){
            return new ResponseEntity<>(201,HttpStatus.CREATED);
        }
        User user = new User(signUpForm.getUsername(),passwordEncoder.encode(signUpForm.getPassword()),
                signUpForm.getEmail(),signUpForm.getFullName(),roleRepository.findByName(signUpForm.getRoleName()));
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginForm user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.createToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User currentUser = userService.findByUsername(user.getUsername()).get();
        JwtResponse jwtResponse = new JwtResponse(currentUser.getId(),jwt,userDetails.getUsername(),currentUser.getFullName(),currentUser.getEmail(), userDetails.getAuthorities());
        return ResponseEntity.ok(jwtResponse);
    }
<<<<<<< HEAD
=======

>>>>>>> dev
}
