package com.casestudy.model;

//import com.casestudy.model.enums.Status;

import com.casestudy.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;

    private LocalDate createdAt;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    private LoginUser loginUser;
}

