package com.quantitymeasurement.auth.auth.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username; // stores email

    @Column(nullable = false)
    private String password;

    private String role;

    private String name;

    @Column(unique = true)
    private String mobile;
}