package com.example.cqrsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "user_views") // alohida jadval!
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserView {

    @Id
    private UUID id;

    @Column(unique = true, nullable = false) // bu ham unique
    private String username;

    private String name;
    private String email;

    // Konstruktor DTO dan foydalanish uchun:
    public UserView(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}