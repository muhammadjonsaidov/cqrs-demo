package com.example.cqrsdemo.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class User {

    private final UUID id;

    private final String username;

    private final String name;

    private final String email;

    // Factory Method - invariantlarni tekshirish uchun
    public static User create(UUID id, String username, String name, String email) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username bo'sh bo'lishi mumkin emas");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email noto'g'ri formatda");
        }

        return new User(id, username, name, email);
    }

    // Biznes metodlar — masalan, "updateEmail", "changeName"...
    public User updateEmail(String newEmail) {
        return new User(this.id, this.username, this.name, newEmail);
    }

    public User changeName(String newName) {
        return new User(this.id, this.username, newName, this.email);
    }
}
