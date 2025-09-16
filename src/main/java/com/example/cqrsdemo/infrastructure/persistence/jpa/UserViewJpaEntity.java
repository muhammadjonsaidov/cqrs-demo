package com.example.cqrsdemo.infrastructure.persistence.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "user_views")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserViewJpaEntity {

    @Id
    private UUID id;

    @Column(unique = true, nullable = false)
    private String username;

    private String name;

    private String email;
}
