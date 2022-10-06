package com.casestudy.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class LoginUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<UserRole> roles;


}
