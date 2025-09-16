package com.example.cqrsdemo.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserViewJpaRepository extends JpaRepository<UserViewJpaEntity, UUID> {
    Optional<UserViewJpaEntity> findByUsername(String username);
}