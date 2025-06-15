package com.ecommerce.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data //getter e setters
@NoArgsConstructor // constructor sem argumentos
@AllArgsConstructor // constructor com argumentos
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private String user;

    private String role;
}
