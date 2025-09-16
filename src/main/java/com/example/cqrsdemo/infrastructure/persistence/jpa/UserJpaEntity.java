package com.example.cqrsdemo.infrastructure.persistence.jpa;

import com.example.cqrsdemo.domain.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class UserJpaEntity {

    @Id
    private UUID id;

    @Column(unique = true, nullable = false)
    private String username;

    private String name;

    private String email;

    // Domain -> JPA
    public static UserJpaEntity from(User user) {
        UserJpaEntity entity = new UserJpaEntity();
        entity.setId(user.getId());
        entity.setUsername(user.getUsername());
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());

        return entity;
    }

    // JPA -> Domain
    public User toDomain() {
        return User.create(this.id, this.username, this.name, this.email);
    }
}
