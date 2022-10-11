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
    private String fullName;
    private String address;
    private String email;
    private String phone;
    private String note;
    private LocalDate createdAt;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    private User user;
}

